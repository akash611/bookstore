package com.akash.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akash.bookstore.exception.OriginNotFoundException;
import com.akash.bookstore.exception.SessionExpiredException;
import com.akash.bookstore.model.Stock;
import com.akash.bookstore.service.SearchService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/search")
    public String searchBooks(HttpServletRequest request,
                              @RequestParam(name = "searchBy", defaultValue = "title") String searchBy,
                              @RequestParam(name = "searchValue", defaultValue = "") String searchValue,
                              @RequestParam(name = "origin", required = false) String origin) throws Exception {
        List<Stock> searchedStocks;

        // If searchValue is not empty, perform search
        if (!searchValue.isEmpty()) {
            searchedStocks = searchService.searchStocks(searchBy, searchValue);
        } else {
            // If no search value, set searchedStocks to empty list
            searchedStocks = null;
        }

        // Set searchedStocks attribute in session
        HttpSession session = request.getSession(false); // Get existing session, if any
        if (session != null) {
            session.setAttribute("searchedStocks", searchedStocks);
            session.setAttribute("searchValue", searchValue);
            session.setAttribute("searchBy", searchBy);
            if(!origin.isEmpty() && origin!=null) {
                return "redirect:/"+origin;
            } else {
                throw new OriginNotFoundException("Origin not found");
            }
        } else {
            throw new SessionExpiredException("Session expired");
        }
    }

    @PostMapping("/removeSearchedStocks")
    public String removeSearchedStocks(HttpServletRequest request, @RequestParam(name = "origin") String origin) throws Exception {
        // Get the session
        HttpSession session = request.getSession(false);

        // Check if session exists
        if (session != null) {
            // Remove searched stocks attribute from session
            searchService.removeSearchedStocksAndParameters(session);
            if(!origin.isEmpty() && origin!=null) {
                return "redirect:/"+origin;
            } else {
                throw new OriginNotFoundException("Origin not found");
            }
        } else {
            throw new SessionExpiredException("Session expired");
        }

       
    }
}