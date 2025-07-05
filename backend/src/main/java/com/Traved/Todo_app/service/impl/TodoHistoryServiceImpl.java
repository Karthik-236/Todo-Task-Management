package com.Traved.Todo_app.service.impl;

import com.Traved.Todo_app.model.Todo;
import com.Traved.Todo_app.model.TodoHistory;
import com.Traved.Todo_app.model.User;
import com.Traved.Todo_app.repository.TodoHistoryRepository;
import com.Traved.Todo_app.service.TodoHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoHistoryServiceImpl implements TodoHistoryService {

    @Autowired
    private TodoHistoryRepository todoHistoryRepository;

    @Override
    public List<TodoHistory> getAllHistory() {
        return todoHistoryRepository.findAll();
    }

    @Override
    public List<TodoHistory> getHistoryByTodoId(Long todoId) {
        return todoHistoryRepository.findByTodo_TodoId(todoId);
    }

    @Override
    public void logAction(Todo todo, String action, User user) {
        TodoHistory history = new TodoHistory();
        history.setTodo(todo);
        history.setAction(action);
        history.setUser(user); 
        history.setTimestamp(LocalDateTime.now());
        todoHistoryRepository.save(history);
    }
}