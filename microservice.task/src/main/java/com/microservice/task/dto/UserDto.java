package com.microservice.task.dto;

import com.microservice.task.entities.TaskStatus;
<<<<<<< HEAD
=======
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
>>>>>>> feature/user-service
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
<<<<<<< HEAD
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Long userId;
}
=======
public class UserDto {

    private String fullName;


    private String email;


    private String password;
}

>>>>>>> feature/user-service
