package com.groupA.Task_Management_System.controller;


import com.groupA.Task_Management_System.payload.request.TaskRequest;
import com.groupA.Task_Management_System.payload.response.ApiResponse;
import com.groupA.Task_Management_System.payload.response.TaskResponse;
import com.groupA.Task_Management_System.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<TaskResponse>> createTask(@RequestBody TaskRequest taskRequest) {
        return taskService.createTask(taskRequest);
    }
}
