package com.example.autorizationservice.controller;

import com.example.autorizationservice.repository.Authorities;
import com.example.autorizationservice.service.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    private final AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        System.out.format("User: %s, password: %s ", user, password);
        return service.getAuthorities(user, password);
    }
}