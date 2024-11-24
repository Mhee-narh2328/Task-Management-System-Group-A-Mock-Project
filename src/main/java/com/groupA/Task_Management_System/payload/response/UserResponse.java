package com.groupA.Task_Management_System.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    //The response it displays if user registration is successful

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;
}
