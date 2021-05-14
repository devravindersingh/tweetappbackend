package com.ravinder.singh.tweetappbackend.model;


import com.mongodb.internal.connection.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {

    private Long id;
    private User user;
    private String tag;
    private Time time;
    private String message;
    private BigInteger likes;
    private BigInteger dislikes;
    private List<Reply> reply;

}
