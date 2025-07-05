package com.Traved.Todo_app.service;

import com.Traved.Todo_app.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
}