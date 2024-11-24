package com.groupA.Task_Management_System.service;

import com.groupA.Task_Management_System.payload.request.TaskRequest;
import com.groupA.Task_Management_System.payload.response.ApiResponse;
import com.groupA.Task_Management_System.payload.response.TaskResponse;
import org.springframework.http.ResponseEntity;

public interface TaskService {

    ResponseEntity<ApiResponse<TaskResponse>> createTask(TaskRequest taskRequest);
}
