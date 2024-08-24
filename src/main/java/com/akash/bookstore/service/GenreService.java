package com.akash.bookstore.service;
import com.akash.bookstore.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAll();

	Genre findByName(String searchValue);


 
}