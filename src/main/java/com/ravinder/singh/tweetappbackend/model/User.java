package com.ravinder.singh.tweetappbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Document(value = "users")
public class User {

    @Id
    private String id;
    @NotBlank
    @Size(max = 20)
    private String firstName;
    @NotBlank
    @Size(max = 20)
    private String lastName;
    @NotBlank
    @Size(max = 20)
    private String userName;
    @NotBlank
    @Email
    @Size(max = 50)
    private String email;
     
    @NotBlank
    @Size(max = 120)
    private String password;
    @NotBlank
    @Size(max = 12)
    private String contactNumber;

    public User(String firstName, String lastName, String username, String email, String password, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = username;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
    }
}
