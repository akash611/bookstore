package com.akash.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.bookstore.model.Buyer;



public interface BuyerRepository extends JpaRepository<Buyer, Long> {

}