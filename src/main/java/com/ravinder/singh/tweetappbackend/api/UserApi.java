package com.ravinder.singh.tweetappbackend.api;

import com.ravinder.singh.tweetappbackend.dto.request.ChangePasswordRequest;
import com.ravinder.singh.tweetappbackend.dto.request.LoginRequest;
import com.ravinder.singh.tweetappbackend.dto.request.RegisterRequest;
import com.ravinder.singh.tweetappbackend.dto.response.LoginResponse;
import com.ravinder.singh.tweetappbackend.dto.response.RegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1.0/user")
public interface UserApi {
    @PostMapping("/register")
    ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest registerRequest);
    @GetMapping("/login")
    ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest);
    @GetMapping("/{userName}/forgot")
    ResponseEntity<String> changePassword(@PathVariable String userName, @RequestBody ChangePasswordRequest changePasswordRequest);
}
