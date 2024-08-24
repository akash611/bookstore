package com.akash.bookstore.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.bookstore.model.Book;
import com.akash.bookstore.model.Executive;
import com.akash.bookstore.model.Stock;
import com.akash.bookstore.model.User;
import com.akash.bookstore.repository.BookRepository;
import com.akash.bookstore.repository.StockRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;


@Service
public class ExecutiveServiceImpl implements ExecutiveService {
@Autowired
StockRepository stockRepository;
@Autowired
BookRepository bookRepository;
	

	@Override
	public void addbook(Book book, Stock stock, HttpSession session) {
		 User user = (User) session.getAttribute("user");
		    LocalDateTime currentDate = LocalDateTime.now();
		    book.setAddedBy((Executive) user);
		    book.setAdditionDate(currentDate);
		    book.setLastModifiedBy((Executive) user);
		    book.setLastModificationDate(currentDate);
		    Book savedBook = bookRepository.save(book);
		    stock.setBook(savedBook);
		   stockRepository.save(stock);

}


	@Override
	public void updateStock(Long id, Integer quantity) {
		Optional<Stock> stockOptional = stockRepository.findById(id);
		if (stockOptional.isPresent()) {
			Stock stock = stockOptional.get();
			stock.setQuantity(quantity);
			stockRepository.save(stock);
		}
		else throw new EntityNotFoundException("Stock not Found");
		
	}


	@Override
	public Book findByBookCode(String bookCode) {
		return bookRepository.findBybookCode(bookCode);
	}
}
