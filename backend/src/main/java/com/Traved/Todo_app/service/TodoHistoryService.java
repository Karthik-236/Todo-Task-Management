package com.Traved.Todo_app.service;

import com.Traved.Todo_app.model.Todo;
import com.Traved.Todo_app.model.TodoHistory;
import com.Traved.Todo_app.model.User;

import java.util.List;

public interface TodoHistoryService {

    List<TodoHistory> getAllHistory();

    List<TodoHistory> getHistoryByTodoId(Long todoId);

    void logAction(Todo todo, String action, User user);
}