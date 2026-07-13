package com.example.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SecureController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/authenticate")
    public String authenticate(@RequestParam String username) {
        return jwtTokenProvider.createToken(username);
    }

    @GetMapping("/secure")
    public String secure(Principal principal) {
        return "This is a secure endpoint. Authenticated as: " + principal.getName();
    }
}
