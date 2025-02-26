package com.microservice.user.service;

import com.microservice.user.entities.RolUser;
import com.microservice.user.entities.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User findById(Long id);

    void save(User user);

    List<User> findByIdTask(Long idTask);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    List<User> getUsersByRole(RolUser role);
}
