package com.akash.bookstore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.akash.bookstore.exception.InvalidUsertypeException;
import com.akash.bookstore.exception.SessionExpiredException;
import com.akash.bookstore.model.Book;
import com.akash.bookstore.model.Buyer;
import com.akash.bookstore.model.Executive;
import com.akash.bookstore.model.Genre;
import com.akash.bookstore.model.Stock;
import com.akash.bookstore.model.User;
import com.akash.bookstore.service.BookAndStoreService;
import com.akash.bookstore.service.GenreService;
import com.akash.bookstore.service.StockService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookAndStoreController {
	@Autowired
	StockService stockService;
	@Autowired
	GenreService genreService;
	@Autowired
	BookAndStoreService bookAndStoreService;

	@GetMapping("/viewbook/{bookCode}")
	public String viewOrEditBook(@PathVariable("bookCode") String bookCode, Model model, HttpServletRequest request) {
		// Find the book with the given bookCode
		HttpSession httpSession = request.getSession(false);
		User user = (User) httpSession.getAttribute("user");
		Book book = bookAndStoreService.findByBookCode(bookCode);
		List<Genre> genres = genreService.findAll();
		if (user instanceof Executive) {
			model.addAttribute("book", book);
			model.addAttribute("genres", genres);
			return "editbook";
		} else {
			model.addAttribute("book", book);
			return "viewbook";
		}
	}

	@PostMapping("/editbook")
	public String editbook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpServletRequest request,
			Model model, RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession(false);
		List<FieldError> errors = new ArrayList<FieldError>();
		if (result.hasErrors()) {
			errors.addAll(result.getFieldErrors());
			model.addAttribute("errors", errors);
			model.addAttribute("genres", genreService.findAll());
			return "editbook";
		}

		bookAndStoreService.updateBook(book, session);

		redirectAttributes.addFlashAttribute("msg", "Book information is updated.");

		return "redirect:/viewbook/" + book.getBookCode();
	}

	@GetMapping("/bookstore")
	public String getAllBooks(HttpServletRequest request, Model model) {
		HttpSession httpsession = request.getSession(false);
		User user = null;
		List<Stock> searchedStocks = null;
		if (httpsession != null) {
			user = (User) httpsession.getAttribute("user");
			searchedStocks = (List<Stock>) httpsession.getAttribute("searchedStocks");
		}
		if (user instanceof Executive) {
			throw new InvalidUsertypeException("Please login as a Buyer");
		}
		if (searchedStocks != null) {
			// If searchedStocks exists, set it in the model
			model.addAttribute("stocks", searchedStocks);
			model.addAttribute("flag", 1);
		} else {
			// If searchedStocks does not exist, retrieve all stocks
			List<Stock> stocks = stockService.findAll();
			model.addAttribute("stocks", stocks);
			model.addAttribute("flag", 0);
		}

		// Add genres to the model
		List<Genre> genres = genreService.findAll();
		model.addAttribute("genres", genres);
		model.addAttribute("origin", "bookstore");

		return "bookstore";
	}

	@PostMapping("/addtocart")
	public String addToCart(@RequestParam(name = "orderVolume") int orderVolume,
			@RequestParam(name = "bookCode") String bookCode, HttpServletRequest request) {
		HttpSession httpSession = request.getSession(false);
		bookAndStoreService.addBookToCart(orderVolume, bookCode, httpSession);
		return "redirect:/bookstore";

	}

	@GetMapping("/cart")
	public String showCart(Model model, HttpServletRequest request) {
		HttpSession httpsession = request.getSession(false);
		User user = null;
		if (httpsession != null) {
			user = (User) httpsession.getAttribute("user");
		}
		if (!(user instanceof Buyer)) {
			throw new InvalidUsertypeException("Please login as a Buyer");
		}
		HashMap<Book, Integer> cart = (HashMap<Book, Integer>) httpsession.getAttribute("cart");
		model.addAttribute("cart", cart);
		return "cart";
	}
	@GetMapping("/profile")
	public String manageProfile(Model model, HttpServletRequest request) {
		HttpSession httpsession = request.getSession(false);
		User user = null;
		if (httpsession != null) {
			user = (User) httpsession.getAttribute("user");
			if(user instanceof Executive) {
				model.addAttribute("user",user);
				return "executiveprofile";
			}
			else if(user instanceof Buyer) {
				model.addAttribute("user",user);
				return "buyerprofile";
			}
			else {
				throw new SessionExpiredException("Pls Log in");
			}
		}
		throw new SessionExpiredException("Pls Log in");
	}

}
