package com.ravinder.singh.tweetappbackend;

import com.ravinder.singh.tweetappbackend.model.User;
import com.ravinder.singh.tweetappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TweetappbackendApplication {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(TweetappbackendApplication.class, args);
	}

}
