package com.Traved.Todo_app.controller;

import com.Traved.Todo_app.model.UserTodo;
import com.Traved.Todo_app.service.UserTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user-todos")
public class UserTodoController {

    @Autowired
    private UserTodoService userTodoService;
    @PostMapping
    public UserTodo assignUserToTodo(@RequestBody UserTodo userTodo) {
        return userTodoService.assignUserToTodo(userTodo);
    }

    @GetMapping
    public List<UserTodo> getAllAssignments() {
        return userTodoService.getAllAssignments();
    }

    @GetMapping("/{id}")
    public UserTodo getAssignmentById(@PathVariable Long id) {
        return userTodoService.getAssignmentById(id);
    }

    @PutMapping("/{id}")
    public UserTodo updateAssignment(@PathVariable Long id, @RequestBody UserTodo updated) {
        return userTodoService.updateAssignment(id, updated);
    }

    @DeleteMapping("/{id}")
    public String deleteAssignment(@PathVariable Long id) {
        userTodoService.deleteAssignment(id);
        return "Assignment deleted";
    }
}