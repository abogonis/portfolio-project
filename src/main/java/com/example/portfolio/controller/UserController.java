package com.example.portfolio.controller;

import com.example.portfolio.dto.User;
import com.example.portfolio.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/users")
    public Iterable<User> users() {
        return userDAO.findAll();
    }

}
