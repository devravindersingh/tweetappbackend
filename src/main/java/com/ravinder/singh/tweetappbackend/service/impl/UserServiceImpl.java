package com.ravinder.singh.tweetappbackend.service.impl;

import com.ravinder.singh.tweetappbackend.dto.request.RegisterRequest;
import com.ravinder.singh.tweetappbackend.dto.response.RegisterResponse;
import com.ravinder.singh.tweetappbackend.model.User;
import com.ravinder.singh.tweetappbackend.repository.UserRepository;
import com.ravinder.singh.tweetappbackend.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        String userName = RandomStringUtils.randomAlphabetic(10) + RandomUtils.nextInt();
        User user = new User(registerRequest.getFirstName(), registerRequest.getLastName(), userName, registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getContactNumber());
        try{
            userRepository.save(user);
        }catch (IllegalArgumentException ex){
            throw ex;
        }
        return new RegisterResponse(userName, "Registeration Successfull");
    }
}
