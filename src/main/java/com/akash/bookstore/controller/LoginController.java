package com.akash.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akash.bookstore.exception.InvalidCredentialsException;
import com.akash.bookstore.model.Executive;
import com.akash.bookstore.model.User;
import com.akash.bookstore.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public String showloginpage() {

		return "login";
	}

	@GetMapping(value = "/logout")
	public String processLogOut(HttpServletRequest request) {
		HttpSession httpSession= request.getSession(false);
			httpSession.invalidate();
			return "redirect:/";
	}


	@PostMapping(value = "/login")

	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, Model model) {
//		User user = loginService.findByUsername(username);
		User user = loginService.authenticateuser(username);
		if (user != null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();

			session.setAttribute("user", user);
			if (user instanceof Executive) {
				return "redirect:/dashboard";
			}
			else{
				return "redirect:/bookstore";
			}
			
//			else {
//				throw new InvalidCredentialsException("User is not an executive or buyer");
//			}

		} else {
			throw new InvalidCredentialsException("Invalid username or password");
		}

	}

}