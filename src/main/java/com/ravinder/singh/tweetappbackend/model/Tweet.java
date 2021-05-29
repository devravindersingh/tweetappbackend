package com.ravinder.singh.tweetappbackend.model;


import com.mongodb.internal.connection.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.List;

@Data
@NoArgsConstructor
@Document(value = "tweets")
public class Tweet {

    @Id
    private String id;
    @DBRef
    private User user;
    @Size(max = 20)
    private String tag;
    private Time time;
    @NotBlank
    @Size(max = 144)
    private String message;
    private BigInteger likes;
    private BigInteger dislikes;
    private List<Reply> reply;

}
