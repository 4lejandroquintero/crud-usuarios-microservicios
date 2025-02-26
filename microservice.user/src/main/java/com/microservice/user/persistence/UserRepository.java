package com.microservice.user.persistence;

import com.microservice.user.entities.RolUser;
import com.microservice.user.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.taskId = :idTask")
    List<User> findAllUser(@Param("idTask") Long idTask);

    List<User> findByRole(RolUser role);
}
