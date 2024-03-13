package com.example.exam_spring.controllers;

import com.example.exam_spring.entities.User;
import com.example.exam_spring.respositories.UserRespositoty;
import com.example.exam_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @PostMapping()
    public User createUser(@RequestBody User user){
    return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/search")
    public List<User> search(String name) {
        return userService.searchUser(name);
    }
}
