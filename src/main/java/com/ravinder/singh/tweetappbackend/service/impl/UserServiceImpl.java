package com.ravinder.singh.tweetappbackend.service.impl;

import com.ravinder.singh.tweetappbackend.dto.request.ChangePasswordRequest;
import com.ravinder.singh.tweetappbackend.dto.request.RegisterRequest;
import com.ravinder.singh.tweetappbackend.dto.response.RegisterResponse;
import com.ravinder.singh.tweetappbackend.model.User;
import com.ravinder.singh.tweetappbackend.repository.UserRepository;
import com.ravinder.singh.tweetappbackend.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    MongoTemplate mongoTemplate;

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

    @Override
    public String changePassword(String userName, ChangePasswordRequest changePasswordRequest) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(userName));

        Update update = new Update();
        update.set("password", changePasswordRequest.getNewPassword());

        User updateDone = mongoTemplate.findAndModify(query, update, User.class);
        if(updateDone != null)
            return "Password changed successfully";
        else
            return "Something went wrong, Please try again";

    }
}
