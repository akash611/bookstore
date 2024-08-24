package com.akash.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.bookstore.model.Book;
import com.akash.bookstore.model.Genre;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	List<Book> findByAuthor(String searchValue);

	List<Book> findByGenre(Genre genre);

	List<Book> findByTitle(String searchValue);

	List<Book> findByTitleContaining(String searchValue);

	List<Book> findByAuthorContaining(String searchValue);

	Book findBybookCode(String bookCode);

	
}