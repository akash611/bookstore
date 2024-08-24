package com.akash.bookstore.service;

import com.akash.bookstore.model.Book;
import com.akash.bookstore.model.Stock;

import jakarta.servlet.http.HttpSession;


public interface ExecutiveService {

	void addbook(Book book,  Stock stock, HttpSession session);

	void updateStock(Long id, Integer quantity);

	Book findByBookCode(String bookCode);

}
