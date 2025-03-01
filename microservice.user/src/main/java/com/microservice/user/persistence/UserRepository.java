package com.microservice.user.persistence;

import com.microservice.user.entities.RolUser;
import com.microservice.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByRoles(RolUser roles);
}
