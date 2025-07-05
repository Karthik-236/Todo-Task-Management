package com.Traved.Todo_app.service;

import com.Traved.Todo_app.model.Todo;
import java.util.List;

public interface TodoService {
    Todo createTodo(Todo todo);
    Todo updateTodo(Long id, Todo updatedTodo);
    void deleteTodo(Long id);
    List<Todo> getAllTodos();
    Todo assignTodoToUser(Long todoId, Long userId);
}