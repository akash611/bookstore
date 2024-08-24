package com.akash.bookstore.service;

import com.akash.bookstore.model.Book;

import jakarta.servlet.http.HttpSession;
public interface BookAndStoreService {

	Book save(Book book);
	Book findByBookCode(String bookCode);
	void updateBook(Book book, HttpSession session);

	public void addBookToCart(int orderVolume, String bookCode, HttpSession httpSession);

}
