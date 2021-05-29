package com.ravinder.singh.tweetappbackend.service;

import com.ravinder.singh.tweetappbackend.dto.request.RegisterRequest;
import com.ravinder.singh.tweetappbackend.dto.response.RegisterResponse;

public interface UserService {

    RegisterResponse registerUser(RegisterRequest registerRequest);

}
