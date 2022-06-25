package com.auth.projetologin.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.projetologin.model.User;
import com.auth.projetologin.model.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping("/all")
    List<User> listAll() {
        return repository.findAll();
    }

    @PostMapping("/add")
    String createUser(@RequestBody User user) {
        try {
            var md = MessageDigest.getInstance("MD5");

            BigInteger hash = new BigInteger(1, md.digest(user.getPassword().getBytes()));
            user.setPassword(hash.toString(16));
        } catch (NoSuchAlgorithmException e) {
            return e.toString();
        }
        
        try {
            repository.save(user);
        }
        catch(Exception e) {
            return e.toString();
        }

        return "Ok";
    }
}
