package com.akash.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.bookstore.model.Genre;
import com.akash.bookstore.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	GenreRepository genreRepository;

	@Override
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	@Override
	public Genre findByName(String searchValue) {
		return genreRepository.findByName(searchValue);
	}

}
