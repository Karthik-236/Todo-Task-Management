package com.Traved.Todo_app.service.impl;

import com.Traved.Todo_app.model.UserTodo;
import com.Traved.Todo_app.repository.UserTodoRepository;
import com.Traved.Todo_app.service.UserTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTodoServiceImpl implements UserTodoService {

    @Autowired
    private UserTodoRepository userTodoRepository;

    @Override
    public UserTodo assignUserToTodo(UserTodo userTodo) {
        return userTodoRepository.save(userTodo);
    }

    @Override
    public List<UserTodo> getAllAssignments() {
        return userTodoRepository.findAll();
    }

    @Override
    public UserTodo getAssignmentById(Long id) {
        return userTodoRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignment not found"));
    }

    @Override
    public UserTodo updateAssignment(Long id, UserTodo updated) {
        UserTodo existing = getAssignmentById(id);
        existing.setUser(updated.getUser());
        existing.setTodo(updated.getTodo());
        return userTodoRepository.save(existing);
    }

    @Override
    public void deleteAssignment(Long id) {
        userTodoRepository.deleteById(id);
    }
}