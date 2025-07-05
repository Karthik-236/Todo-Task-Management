package com.Traved.Todo_app.controller;

import com.Traved.Todo_app.model.TodoHistory;
import com.Traved.Todo_app.service.TodoHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/todo-history")
public class TodoHistoryController {

    @Autowired
    private TodoHistoryService todoHistoryService;

    @GetMapping
    public List<TodoHistory> getAllHistory() {
        return todoHistoryService.getAllHistory();
    }

    @GetMapping("/todo/{todoId}")
    public List<TodoHistory> getHistoryByTodoId(@PathVariable Long todoId) {
        return todoHistoryService.getHistoryByTodoId(todoId);
    }
}