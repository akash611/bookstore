package com.akash.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.bookstore.model.Book;
import com.akash.bookstore.model.Genre;
import com.akash.bookstore.model.Stock;
import com.akash.bookstore.repository.BookRepository;
import com.akash.bookstore.repository.GenreRepository;
import com.akash.bookstore.repository.StockRepository;

import jakarta.servlet.http.HttpSession;
@Service
public class SearchServiceImpl implements SearchService {
@Autowired
BookRepository bookRepository;
@Autowired
GenreRepository genreRepository;
@Autowired
StockRepository stockRepository;

	@Override
	public List<Stock> searchStocks(String searchBy, String searchValue) {
         List<Book> searchedBooks;
         List<Stock> searchedStocks;
		// If searchValue is not empty, perform search
        if (!searchValue.isEmpty()) {
            if ("author".equals(searchBy)) {
                searchedBooks = bookRepository.findByAuthorContaining(searchValue);
            } else if ("genre".equals(searchBy)) {
                Genre genre = genreRepository.findByName(searchValue);
                searchedBooks = bookRepository.findByGenre(genre);
            } else { // Default to title search
                searchedBooks = bookRepository.findByTitleContaining(searchValue);
            }

            // Fetch corresponding stocks for the searched books
            searchedStocks = stockRepository.findByBookIn(searchedBooks);
        } else {
            // If no search value, set searchedStocks to empty list
            searchedStocks =null;
        }
        return searchedStocks;

	}
	@Override
	public void removeSearchedStocksAndParameters(HttpSession session) {
		session.removeAttribute("searchedStocks");
		session.removeAttribute("searchBy");
		session.removeAttribute("searchValue");
		
	}}
