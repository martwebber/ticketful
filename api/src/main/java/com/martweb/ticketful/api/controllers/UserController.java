package com.martweb.ticketful.api.controllers;

import com.martweb.ticketful.api.dtos.CreateUserRequest;
import com.martweb.ticketful.api.dtos.UpdateUserRequest;
import com.martweb.ticketful.api.entities.User;
import com.martweb.ticketful.api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        var users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        var user = userService.getUserById(id);
        return ResponseEntity.of(user);
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest){
        var newUser = userService.createNewUser( createUserRequest);
        return ResponseEntity.status(201).body(newUser);
    }

    @PutMapping("update-user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest){
        var updatedUser = userService.updateUser(id,updateUserRequest);
        return ResponseEntity.of(updatedUser);
    }

    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<HashMap<Object,Object>> deleteUser(@PathVariable Long id){
        var validate = userService.deleteUser(id);
        return ResponseEntity.ok(validate);
    }

}
