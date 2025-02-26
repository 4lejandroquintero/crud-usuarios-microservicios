package com.microservice.task.client;

<<<<<<< HEAD
public interface UserClient {
=======
import com.microservice.task.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-user", url = "localhost:8090/api/v1/user")
public interface UserClient {

    @GetMapping("/user/{userId}")
    List<UserDto> findAllUsersByTask(@PathVariable Long userId);
>>>>>>> feature/user-service
}
