package com.akash.bookstore.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.akash.bookstore.model.Executive;
import com.akash.bookstore.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@ControllerAdvice
public class Handler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public String handleInvalidCredentialsException(InvalidCredentialsException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        
        return "login";
    }
    
   
    @ExceptionHandler(SessionExpiredException.class)
    public String handleSessionExpiredException(SessionExpiredException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "login";
    }
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model, HttpServletRequest request) {
    	model.addAttribute("error", ex.getMessage());
    	HttpSession httpsession= request.getSession(false);
    
    	if (httpsession != null) {
	        User user = (User) httpsession.getAttribute("user");
	        if (user instanceof Executive) {
	        	return "executiveerror";
	        }
	        else  {
	        	return "storeerror";
	        }
	       
    	}
    	return "storeerror";
    }
   
}