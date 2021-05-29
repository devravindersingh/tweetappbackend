package com.ravinder.singh.tweetappbackend.repository;

import com.ravinder.singh.tweetappbackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    User findByUserName(String username);
}
