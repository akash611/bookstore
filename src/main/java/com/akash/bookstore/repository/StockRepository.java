package com.akash.bookstore.repository;

import com.akash.bookstore.model.Book;
import com.akash.bookstore.model.Stock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {;

	List<Stock> findByBookIn(List<Book> searchedBooks);
}