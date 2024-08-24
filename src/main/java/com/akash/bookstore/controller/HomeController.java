package com.akash.bookstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.akash.bookstore.model.Buyer;
import com.akash.bookstore.model.Executive;
import com.akash.bookstore.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request) {
    	HttpSession httpsession = request.getSession(false);
    	if(httpsession!=null) {
    		User user = (User) httpsession.getAttribute("user");
    		if (user instanceof Executive) {
    			return "redirect:/dashboard";
    		}
    		else if(user instanceof Buyer) {
    		 return "redirect:/bookstore";
    	
    	}
	}
		return "redirect:/bookstore";
    }
    }
   



