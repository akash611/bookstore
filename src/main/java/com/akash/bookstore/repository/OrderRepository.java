package com.akash.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.bookstore.model.Order;
@Repository
public interface OrderRepository extends  JpaRepository<Order, Long> {

}
