package com.Traved.Todo_app.service.impl;

import com.Traved.Todo_app.model.*;
import com.Traved.Todo_app.repository.*;
import com.Traved.Todo_app.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepo;
    private final UserRepository userRepo;
    private final UserTodoRepository userTodoRepo;
    private final TodoHistoryRepository historyRepo;

    private void saveHistory(Todo todo, User user, String action) {
        TodoHistory history = new TodoHistory(null, todo, user, action, null);
        historyRepo.save(history);
    }

    @Override
    public Todo createTodo(Todo todo) {
        Todo saved = todoRepo.saveAndFlush(todo); // ensures ID is generated
        saveHistory(saved, null, "Todo Created");
        return saved;
    }

    @Override
    public Todo updateTodo(Long id, Todo updatedTodo) {
        Todo todo = todoRepo.findById(id).orElseThrow();
        todo.setTitle(updatedTodo.getTitle());
        todo.setListOfItems(updatedTodo.getListOfItems());
        todo.setStatus(updatedTodo.getStatus());
        todo.setActive(updatedTodo.isActive());
        Todo saved = todoRepo.saveAndFlush(todo);
        saveHistory(saved, null, "Todo Updated");
        return saved;
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepo.findById(id).orElseThrow();
        todoRepo.delete(todo);
        saveHistory(todo, null, "Todo Deleted");
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    @Override
    public Todo assignTodoToUser(Long todoId, Long userId) {
        Todo todo = todoRepo.findById(todoId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();
        userTodoRepo.save(new UserTodo(null, user, todo));
        saveHistory(todo, user, "Todo Assigned");
        return todo;
    }
}