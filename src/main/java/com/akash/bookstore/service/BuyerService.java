package com.akash.bookstore.service;

import com.akash.bookstore.model.Buyer;
import com.akash.bookstore.model.User;

public interface BuyerService {

	User findUserbyUsername(String username);
	User findUserbyEmailId(String emailId);
	void addBuyer (Buyer buyer);

}
