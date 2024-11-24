package com.groupA.Task_Management_System.service.impl;

import com.groupA.Task_Management_System.entity.Task;
import com.groupA.Task_Management_System.entity.User;
import com.groupA.Task_Management_System.payload.request.TaskRequest;
import com.groupA.Task_Management_System.payload.response.ApiResponse;
import com.groupA.Task_Management_System.payload.response.TaskResponse;
import com.groupA.Task_Management_System.repository.TaskRepository;
import com.groupA.Task_Management_System.repository.UserRepository;
import com.groupA.Task_Management_System.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.groupA.Task_Management_System.entity.enums.TaskStatus.PENDING;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    @Override
    public ResponseEntity<ApiResponse<TaskResponse>> createTask(TaskRequest taskRequest) {

        // Validate if the user exists by email
       if (!userRepository.existsByEmail(taskRequest.getEmail())) {
           throw new EntityNotFoundException("User Not Found With Email: " + taskRequest.getEmail());
       }

        // Fetch the user entity
        User user = userRepository.findByEmail(taskRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found with email: " + taskRequest.getEmail()));

        // Create a new Task entity based on the TaskRequest
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDeadline(taskRequest.getDeadline());
        task.setPriorityLevel(taskRequest.getPriorityLevel());
        task.setTaskStatus(PENDING);  //Automatically setting task status to PENDING
        task.setUser(user); //Associate the task with the user
        Task savedTask = taskRepository.save(task);

        TaskResponse taskResponse = mapToTaskResponse(savedTask);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Task created successfully", taskResponse));
    }

    private TaskResponse mapToTaskResponse(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setUserId(task.getUser().getId());
        taskResponse.setTitle(task.getTitle());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setDeadline(task.getDeadline());
        taskResponse.setPriorityLevel(task.getPriorityLevel());
        taskResponse.setTaskStatus(task.getTaskStatus());
        return taskResponse;
    }
}
