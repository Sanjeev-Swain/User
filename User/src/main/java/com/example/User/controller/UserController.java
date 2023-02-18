package com.example.User.controller;

import com.example.User.model.User;
import com.example.User.service.IUserService;
import com.example.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-app")
public class UserController {


    @Autowired
    private IUserService userService;

    @PostMapping("/add-user")
    public void addUser(@RequestBody User user)
    {
        userService.addUser(user);
    }

    @GetMapping("/find-user/id/{id}")
    public User findUserById(@PathVariable int id)
    {
        return userService.findById(id);
    }

    @GetMapping("/find-all")
    public List<User> findAllUser()
    {
        return userService.findAll();
    }

    @PutMapping("update-user/id/{id}")
    public void updateUser(@PathVariable int id,@RequestBody User user)
    {
        userService.updateUser(id,user);
    }
    @DeleteMapping("/delete-user/id/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userService.deleteUser(id);
    }




}
