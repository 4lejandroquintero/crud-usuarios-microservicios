package com.microservice.task.controller;

import com.microservice.task.dto.TaskDto;
<<<<<<< HEAD
=======
import com.microservice.task.dto.UserDto;
>>>>>>> feature/user-service
import com.microservice.task.service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final ITaskService taskService;

<<<<<<< HEAD
    @PostMapping
=======
    @PostMapping("/create")
>>>>>>> feature/user-service
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.createTask(taskDto));
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskDto>> getTasksByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.updateTask(id, taskDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
<<<<<<< HEAD
=======

    @GetMapping("/search-users/{idTask}")
    public ResponseEntity<?> finUsersByIdTask(@PathVariable Long idTask){
        return ResponseEntity.ok(taskService.findUsersByIdTask(idTask));
    }
>>>>>>> feature/user-service
}