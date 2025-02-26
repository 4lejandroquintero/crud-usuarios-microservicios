package com.microservice.user.service;

import com.microservice.user.entities.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User findById(Long id);

    void save(User user);

    List<User> findByIdTask(Long idTask);


}
