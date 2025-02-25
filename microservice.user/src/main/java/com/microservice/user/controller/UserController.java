package com.microservice.user.controller;

import com.microservice.user.entities.User;
import com.microservice.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user){
        iUserService.save(user);
    }

    @GetMapping("/all")
    public ResponseEntity<?> finAllUsers(){
        return ResponseEntity.ok(iUserService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(iUserService.findById(id));
    }


}
