package com.microservice.task.service;



import com.microservice.task.dto.TaskDto;
import com.microservice.task.dto.UserDto;
import com.microservice.task.http.response.UsersByTaskResponse;

import java.util.List;

public interface ITaskService {
    TaskDto createTask(TaskDto taskDto);
    List<TaskDto> getAllTasks();
    TaskDto getTaskById(Long id);
    List<TaskDto> getTasksByUserId(Long userId);
    TaskDto updateTask(Long id, TaskDto taskDto);
    void deleteTask(Long id);
    UsersByTaskResponse findUsersByIdTask(Long idTask);
}
