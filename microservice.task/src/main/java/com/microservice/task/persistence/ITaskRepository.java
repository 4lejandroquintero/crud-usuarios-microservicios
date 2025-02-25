package com.microservice.task.persistence;

import com.microservice.task.entities.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends CrudRepository<Task, Long> {

    List<Task> findByUserId(Long userId);
}
