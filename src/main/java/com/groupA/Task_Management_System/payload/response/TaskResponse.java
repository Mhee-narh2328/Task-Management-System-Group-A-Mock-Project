package com.groupA.Task_Management_System.payload.response;


import com.groupA.Task_Management_System.entity.enums.PriorityLevel;
import com.groupA.Task_Management_System.entity.enums.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {

    //The response it displays if task creation is successful

    private Long userId;

    private String title;

    private String description;

    private LocalDateTime deadline;

    @Enumerated(EnumType.STRING)
    private PriorityLevel priorityLevel;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
}
