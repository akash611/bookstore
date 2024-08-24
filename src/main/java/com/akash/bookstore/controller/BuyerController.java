package com.akash.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.akash.bookstore.model.Buyer;
import com.akash.bookstore.service.BuyerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BuyerController {
	
@Autowired
BuyerService buyerService;

    @GetMapping("/signup")
    public String signup(Model model, HttpServletRequest request) {
    	HttpSession session = request.getSession();
        if (session != null ) {
            session.invalidate();
        }

        model.addAttribute("buyer", new Buyer());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("buyer") Buyer buyer, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (buyer.getPassword() != null && buyer.getPassword2() != null && !buyer.getPassword().equals(buyer.getPassword2())) {
            bindingResult.rejectValue("password2", "error.buyer", "Passwords do not match");
            
        }
        if (buyerService.findUserbyUsername(buyer.getUsername()) != null) {
            bindingResult.rejectValue("username", "error.buyer", "Username is already taken");
        }
        if (buyerService.findUserbyEmailId(buyer.getEmailId()) != null) {
            bindingResult.rejectValue("emailId", "error.buyer", "Email Id is already taken");
        }

        if (bindingResult.hasErrors()) {
        	List<FieldError> errors = new ArrayList<FieldError>();
        	 errors.addAll(bindingResult.getFieldErrors());
        	model.addAttribute("errors", errors);
            return "signup";
        }

        buyerService.addBuyer(buyer);
        	redirectAttributes.addFlashAttribute("msg",  buyer.getName()+" , You can Log in Now");
        	return "redirect:/login";
       }
}