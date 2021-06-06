package com.ravinder.singh.tweetappbackend.service;

import com.ravinder.singh.tweetappbackend.dto.request.ChangePasswordRequest;
import com.ravinder.singh.tweetappbackend.dto.request.RegisterRequest;
import com.ravinder.singh.tweetappbackend.dto.response.RegisterResponse;

public interface UserService {

    RegisterResponse registerUser(RegisterRequest registerRequest);
    String changePassword(String userName, ChangePasswordRequest changePasswordRequest);

}
