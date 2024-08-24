package com.akash.bookstore.service;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.bookstore.exception.SessionExpiredException;
import com.akash.bookstore.model.Book;
import com.akash.bookstore.model.Executive;
import com.akash.bookstore.model.User;
import com.akash.bookstore.repository.BookRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;

@Service
public class BookAndStoreServiceImpl implements BookAndStoreService {
@Autowired
BookRepository bookRepository;

@Override
public Book save(Book book) {
    return bookRepository.save(book);
}

@Override
public Book findByBookCode(String bookCode) {
    Book book = bookRepository.findBybookCode(bookCode);
    if (book==null) {
        throw new EntityNotFoundException("Book not found with bookCode: " + bookCode);
    }
    return book;
}


@Override
public void updateBook(Book book, HttpSession session) {
	 User user = (User) session.getAttribute("user");
	    LocalDateTime currentDate = LocalDateTime.now();

	    book.setLastModifiedBy((Executive) user);
	    book.setLastModificationDate(currentDate);
	    bookRepository.save(book);
	
	
}
@Override
public void addBookToCart(int orderVolume, String bookCode, HttpSession httpSession) {
	if(httpSession==null || httpSession.getAttribute("user")==null) {
		throw new SessionExpiredException("Please Log in to Buy Books");
	}
	Book book = bookRepository.findBybookCode(bookCode);
	if(httpSession.getAttribute("cart")!=null) {
		HashMap<Book,Integer> cart  = (HashMap<Book, Integer>) httpSession.getAttribute("cart");
		cart.put(book, orderVolume);
	}
	else {
		HashMap<Book,Integer> cart = new HashMap<>();
		cart.put(book, orderVolume);
		httpSession.setAttribute("cart", cart);
	}
	
}


}
