package com.ravinder.singh.tweetappbackend.controller;

import com.ravinder.singh.tweetappbackend.dto.request.LoginRequest;
import com.ravinder.singh.tweetappbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String getWelcome(){
        return "Welcome to tweetapp Backend ";
    }


}
