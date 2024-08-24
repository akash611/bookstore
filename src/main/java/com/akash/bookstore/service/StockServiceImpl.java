package com.akash.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.bookstore.model.Stock;
import com.akash.bookstore.repository.StockRepository;
@Service
public class StockServiceImpl implements StockService {
	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Stock> findAll() {
		return stockRepository.findAll();
	}

	
}