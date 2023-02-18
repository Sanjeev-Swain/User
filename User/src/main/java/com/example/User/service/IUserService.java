package com.example.User.service;

import com.example.User.model.User;

import java.util.List;
import java.util.function.Predicate;

public interface IUserService {

    public List<User> findAll();

    public User findById(int id);

    public void addUser(User user);

    public void deleteUser(int id);

    public void updateUser(int id,User newUser);

}
