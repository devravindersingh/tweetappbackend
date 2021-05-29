package com.ravinder.singh.tweetappbackend.controller;

import com.ravinder.singh.tweetappbackend.api.UserApi;
import com.ravinder.singh.tweetappbackend.dto.request.ChangePasswordRequest;
import com.ravinder.singh.tweetappbackend.dto.request.LoginRequest;
import com.ravinder.singh.tweetappbackend.dto.request.RegisterRequest;
import com.ravinder.singh.tweetappbackend.dto.response.LoginResponse;
import com.ravinder.singh.tweetappbackend.dto.response.RegisterResponse;
import com.ravinder.singh.tweetappbackend.service.UserService;
import com.ravinder.singh.tweetappbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseEntity<RegisterResponse> registerUser(RegisterRequest registerRequest) {
        RegisterResponse registerResponse = userService.registerUser(registerRequest);
        ResponseEntity<RegisterResponse> response = new ResponseEntity<>(registerResponse,HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<LoginResponse> loginUser(LoginRequest loginRequest) {
        LoginResponse loginResponse = null;
        try {
            String token = generateToken(loginRequest);
            loginResponse = new LoginResponse(token,"Successfull");
            ResponseEntity<LoginResponse> response = new ResponseEntity<>(loginResponse, HttpStatus.OK);
            return response;
        }catch (Exception ex){
            loginResponse = new LoginResponse("",ex.getMessage());
            ResponseEntity<LoginResponse> response = new ResponseEntity<>(loginResponse, HttpStatus.BAD_REQUEST);
            return response;
        }
    }
    //Todo
    @Override
    public ResponseEntity<String> changePassword(ChangePasswordRequest changePasswordRequest) {
        return null;
    }

    public String generateToken(LoginRequest loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword())
            );
        }catch (Exception ex){
            throw new Exception("Invalid username or password");
        }
        return jwtUtil.generateToken(loginRequest.getUserName());
    }
}
