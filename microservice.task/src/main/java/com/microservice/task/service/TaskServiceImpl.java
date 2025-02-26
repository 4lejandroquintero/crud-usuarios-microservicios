package com.microservice.task.service;

<<<<<<< HEAD
import com.microservice.task.dto.TaskDto;
import com.microservice.task.entities.Task;
import com.microservice.task.entities.TaskStatus;
import com.microservice.task.persistence.ITaskRepository;
import lombok.RequiredArgsConstructor;
=======
import com.microservice.task.client.UserClient;
import com.microservice.task.dto.TaskDto;
import com.microservice.task.dto.UserDto;
import com.microservice.task.entities.Task;
import com.microservice.task.entities.TaskStatus;
import com.microservice.task.http.response.UsersByTaskResponse;
import com.microservice.task.persistence.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> feature/user-service
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements ITaskService {

<<<<<<< HEAD
    private final ITaskRepository taskRepository;

=======
    @Autowired
    private final ITaskRepository taskRepository;

    @Autowired
    private UserClient userClient;

>>>>>>> feature/user-service
    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = Task.builder()
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .status(TaskStatus.ASIGNADA)
                .userId(taskDto.getUserId())
                .build();

        Task savedTask = taskRepository.save(task);
        return mapToDto(savedTask);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        Iterable<Task> tasks = taskRepository.findAll();
        return StreamSupport.stream(tasks.spliterator(), false) // Convertimos Iterable a Stream
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));
        return mapToDto(task);
    }

    @Override
    public List<TaskDto> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));

        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());

        Task updatedTask = taskRepository.save(task);
        return mapToDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Tarea no encontrada con ID: " + id);
        }
        taskRepository.deleteById(id);
    }

    private TaskDto mapToDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .userId(task.getUserId())
                .build();
    }
<<<<<<< HEAD
=======

    @Override
    public UsersByTaskResponse findUsersByIdTask(Long idTask) {

        // Consultar la task
        Task task = taskRepository.findById(idTask).orElse(new Task());

        // Obtener los usuarios
        List<UserDto> userDtoList = userClient.findAllUsersByTask(idTask);
        return UsersByTaskResponse.builder()
                .title(task.getTitle())
                .status(task.getStatus())
                .userDTOList(userDtoList)
                .build();
    }


>>>>>>> feature/user-service
}
