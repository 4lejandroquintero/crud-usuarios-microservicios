package com.microservice.task.dto;

<<<<<<< HEAD
public class TaskDto {
}
=======
import com.microservice.task.entities.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Long userId;
}
>>>>>>> feature/user-service
