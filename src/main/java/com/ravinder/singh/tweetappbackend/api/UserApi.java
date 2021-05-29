package com.ravinder.singh.tweetappbackend.api;

import com.ravinder.singh.tweetappbackend.dto.request.ChangePasswordRequest;
import com.ravinder.singh.tweetappbackend.dto.request.LoginRequest;
import com.ravinder.singh.tweetappbackend.dto.request.RegisterRequest;
import com.ravinder.singh.tweetappbackend.dto.response.LoginResponse;
import com.ravinder.singh.tweetappbackend.dto.response.RegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {
    @PostMapping("/registeruser")
    ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest registerRequest);
    @GetMapping("/loginuser")
    ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest);
    @PostMapping("/forgotpassword")
    ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest);
}
