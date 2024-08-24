package com.akash.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.akash.bookstore.exception.InvalidUsertypeException;
import com.akash.bookstore.exception.SessionExpiredException;
import com.akash.bookstore.model.Book;
import com.akash.bookstore.model.Executive;
import com.akash.bookstore.model.Genre;
import com.akash.bookstore.model.Stock;
import com.akash.bookstore.model.User;
import com.akash.bookstore.service.ExecutiveService;
import com.akash.bookstore.service.GenreService;
import com.akash.bookstore.service.StockService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ExecutiveController {
	@Autowired
	StockService stockService;
	@Autowired
	GenreService genreService;
	@Autowired 
	ExecutiveService executiveService;
	
	

	@GetMapping(value = "/dashboard")
	String showDashboard(HttpServletRequest request, Model model) {
	    HttpSession httpsession = request.getSession(false);
	    if(httpsession!=null) {
	    	User user = (User) httpsession.getAttribute("user");
	    	if(user==null) {
	    		httpsession.invalidate();
	    		throw new SessionExpiredException("Session Expired");
	    	}
	    	else if(!(user instanceof Executive)) {
	    		throw new InvalidUsertypeException("User is not an executive");
	    	}
	    	else {
	    		List<Stock> searchedStocks = (List<Stock>) httpsession.getAttribute("searchedStocks");
	            
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
	            model.addAttribute("origin", "dashboard");
	            
	            return "dashboard";

	    	}
	    }
	    throw new SessionExpiredException("Session Expired");

	    
	    } 
	

	@PostMapping("/updatestock")
	public String updateStock(@RequestParam("id") Long id, @RequestParam("quantity") Integer quantity, RedirectAttributes redirectAttributes) {
		executiveService.updateStock(id,quantity);
		redirectAttributes.addFlashAttribute("msg","Stock is upadated");
		return "redirect:/dashboard";
	}
	@GetMapping("/addnewbook")
	public String addNewBook(HttpServletRequest request, Model model) {
	    HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("user") == null) {
	        throw new SessionExpiredException("Session Expired");
	    }
	    User user = (User) session.getAttribute("user");
	    if (!(user instanceof Executive)) {
	        throw new InvalidUsertypeException("User is not an executive");
	    }
	    Book book = new Book();
	    Stock stock = new Stock();
	    model.addAttribute("book", book);
	    model.addAttribute("Stock", stock);
	    model.addAttribute("genres", genreService.findAll());
	    return "addnewbook";
	   
	}
	
	@PostMapping("/addnewbook")
	public String addNewBook(  @Valid @ModelAttribute("book") Book book , BindingResult result, @Valid @ModelAttribute("stock")Stock stock, BindingResult result2,  HttpServletRequest request, Model model,   RedirectAttributes redirectAttributes) {
	    HttpSession session = request.getSession(false);
	 // Check if the book with the given bookCode already exists
	    Book existingBook = executiveService.findByBookCode(book.getBookCode());
	    List<FieldError> errors = new ArrayList<FieldError>();
	    if(existingBook!= null) {
	        errors.add(new FieldError("book", "bookCode", "A book with this bookCode already exists"));
	    }
	    if (result.hasErrors()) {
	    	 errors.addAll(result.getFieldErrors());	
	    	 }
	    if(result2.hasErrors()) {
	    		 errors.addAll(result2.getFieldErrors());
	    	 }
	    if(result2.hasErrors() || result.hasErrors() || existingBook!= null) {
	    		model.addAttribute("errors", errors);
		        model.addAttribute("genres", genreService.findAll());
	        return "addnewbook";
	    }
	
	    	executiveService.addbook(book, stock,session) ;
	    	redirectAttributes.addFlashAttribute("msg", "NewBook " + book.getTitle() + " is added Succesfully");
	        return "redirect:/dashboard";
	    
	   
	    }
		
	  
	
	}
	
	


