package com.akash.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.akash.bookstore.model.Buyer;
import com.akash.bookstore.model.User;
import com.akash.bookstore.repository.BuyerRepository;
import com.akash.bookstore.repository.UserRepository;

@Service
public  class BuyerServiceImpl implements BuyerService {
@Autowired
UserRepository userRepository;
@Autowired
BuyerRepository buyerRepository;
	@Override
	public User findUserbyUsername(String username) {
		return userRepository.findByUsername(username);
	}
	@Override
	public User findUserbyEmailId(String emailId) {
		return userRepository.findByEmailId(emailId);
	}
	@Override
	public void addBuyer(Buyer buyer) {
		buyerRepository.save(buyer);
	}

}
