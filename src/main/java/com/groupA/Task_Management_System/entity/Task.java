package com.groupA.Task_Management_System.entity;

import com.groupA.Task_Management_System.entity.enums.PriorityLevel;
import com.groupA.Task_Management_System.entity.enums.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task_tbl")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task extends BaseClass {
    //Adding Validation to fields

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;


    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;


    @NotNull(message = "Deadline is required")
    @Future(message = "Deadline must be a future date and time")
    private LocalDateTime deadline;


    @Enumerated(EnumType.STRING)
    @NotNull(message = "Priority level is required")
    private PriorityLevel priorityLevel;


    @Enumerated(EnumType.STRING)
    @NotNull(message = "Task status is required")
    private TaskStatus taskStatus;

    //Mapping Tasks to a Specific User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
