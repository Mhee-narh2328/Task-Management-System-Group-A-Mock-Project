package com.groupA.Task_Management_System.service;

import com.groupA.Task_Management_System.payload.request.UserRequest;
import com.groupA.Task_Management_System.payload.response.ApiResponse;
import com.groupA.Task_Management_System.payload.response.UserResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    //This method is used for creating user
    ResponseEntity<ApiResponse<UserResponse>> registerUser(UserRequest userRequest);
}
