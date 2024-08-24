package com.akash.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.bookstore.model.OrderedBook;

@Repository
public interface OrderedBookRepository extends JpaRepository<OrderedBook, Long> {

}
