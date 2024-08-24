package com.akash.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.bookstore.model.User;
import com.akash.bookstore.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepository;
	@Override
	public User authenticateuser(String username) {
		
		return userRepository.findByUsername(username);

	}

}
