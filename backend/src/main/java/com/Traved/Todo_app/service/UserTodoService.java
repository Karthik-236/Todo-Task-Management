package com.Traved.Todo_app.service;

import com.Traved.Todo_app.model.UserTodo;
import java.util.List;

public interface UserTodoService {
    UserTodo assignUserToTodo(UserTodo userTodo);
    List<UserTodo> getAllAssignments();
    UserTodo getAssignmentById(Long id);
    UserTodo updateAssignment(Long id, UserTodo updated);
    void deleteAssignment(Long id);
}