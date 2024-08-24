package com.akash.bookstore.service;

import java.util.List;

import com.akash.bookstore.model.Stock;

import jakarta.servlet.http.HttpSession;

public interface SearchService {

	List<Stock> searchStocks(String searchBy, String searchValue);

	void removeSearchedStocksAndParameters(HttpSession session);

}
