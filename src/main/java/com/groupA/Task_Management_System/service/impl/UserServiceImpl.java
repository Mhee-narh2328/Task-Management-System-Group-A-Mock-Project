package com.groupA.Task_Management_System.service.impl;

import com.groupA.Task_Management_System.entity.User;
import com.groupA.Task_Management_System.payload.request.UserRequest;
import com.groupA.Task_Management_System.payload.response.ApiResponse;
import com.groupA.Task_Management_System.payload.response.UserResponse;
import com.groupA.Task_Management_System.repository.UserRepository;
import com.groupA.Task_Management_System.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ApiResponse<UserResponse>> registerUser(UserRequest userRequest) {

        boolean isEmailPresent = userRepository.existsByEmail(userRequest.getEmail());

        if (isEmailPresent) {
            throw new RuntimeException("Email already exists");
        }



        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .phoneNumber(String.valueOf(userRequest.getPhoneNumber()))
                .password(userRequest.getPassword())
                .build();

        userRepository.save(newUser);

        UserResponse userResponse = UserResponse.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>("User account created successfully", userResponse));
    }

}
