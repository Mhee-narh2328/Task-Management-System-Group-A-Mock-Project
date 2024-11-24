package com.groupA.Task_Management_System.repository;

import com.groupA.Task_Management_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Checks if an email exists in the database
    boolean existsByEmail( String email);

    // Retrieves a user by email, returning Optional to handle absence
    Optional<User> findByEmail(String email);
}
