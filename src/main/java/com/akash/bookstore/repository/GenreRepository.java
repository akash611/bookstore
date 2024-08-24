package com.akash.bookstore.repository;

import com.akash.bookstore.model.Genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

	Genre findByName(String searchValue);
}