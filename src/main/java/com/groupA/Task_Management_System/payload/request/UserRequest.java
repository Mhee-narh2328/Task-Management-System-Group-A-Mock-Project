package com.groupA.Task_Management_System.payload.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    //These are the fields requested while registering a user

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;
}
