package com.groupA.Task_Management_System.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user_tbl")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseClass{
    //Adding Validations to The Fields

    @NotBlank(message = "First Name is required")
    @Size(min = 3, max = 50, message = "First name must be between 3 and 50 Characters")
    private String firstName;


    @NotBlank(message = "Last Name is required")
    @Size(min = 3, max = 50, message = "Last name must be between 3 and 50 Characters")
    private String lastName;


    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email Address")
    private String email;


    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character, and no spaces"
    )
    private String password;


    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^\\+?[0-9]{10,15}$",
            message = "Phone number must be between 10 and 15 digits and can start with '+'"
    )
    private String phoneNumber;


    //Mapping The User table to Task Table
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
