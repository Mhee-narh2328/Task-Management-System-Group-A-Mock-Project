package com.groupA.Task_Management_System.controller;


import com.groupA.Task_Management_System.payload.request.UserRequest;
import com.groupA.Task_Management_System.payload.response.ApiResponse;
import com.groupA.Task_Management_System.payload.response.UserResponse;
import com.groupA.Task_Management_System.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<ApiResponse<UserResponse>> registerUser(
            @RequestBody UserRequest userRequest) {
        return userService.registerUser(userRequest);
    }
}
