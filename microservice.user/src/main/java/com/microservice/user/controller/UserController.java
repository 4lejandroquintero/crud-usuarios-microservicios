package com.microservice.user.controller;

import com.microservice.user.entities.RolUser;
import com.microservice.user.entities.User;
import com.microservice.user.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(iUserService.findAll());
    }

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

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        return ResponseEntity.ok(iUserService.updateUser(id, user));    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        iUserService.deleteUser(id);
    }

    @GetMapping("/search-by-role/{roles}")
    public ResponseEntity<List<User>> getUsersByRoles(@PathVariable RolUser roles) {
        return ResponseEntity.ok(iUserService.getUsersByRoles(roles));
    }
}
