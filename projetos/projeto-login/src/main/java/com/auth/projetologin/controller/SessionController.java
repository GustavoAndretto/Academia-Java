package com.auth.projetologin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.projetologin.model.Session;
import com.auth.projetologin.model.SessionRepository;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    SessionRepository repository;

    @RequestMapping("/all")
    List<Session> listAll() {
        return repository.findAll();
    }
}