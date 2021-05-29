package com.ravinder.singh.tweetappbackend.model;

import com.mongodb.internal.connection.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {


    private String id;
    private User user;
    private String tag;
    private Time time;
    private String message;
    private BigInteger likes;
    private BigInteger dislikes;
}
