package com.microservice.user.controller;

import com.microservice.user.entities.RolUser;
import com.microservice.user.entities.User;
import com.microservice.user.service.IUserService;
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

    @GetMapping("/search-by-task/{idTask}")
    public ResponseEntity<?> findByIdTask(@PathVariable Long idTask){
        return ResponseEntity.ok(iUserService.findByIdTask(idTask));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(iUserService.updateUser(id, user));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        iUserService.deleteUser(id);
    }

    @GetMapping("/search-by-role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable RolUser role) {
        return ResponseEntity.ok(iUserService.getUsersByRole(role));
    }
}
