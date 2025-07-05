package com.Traved.Todo_app.repository;

import com.Traved.Todo_app.model.TodoHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoHistoryRepository extends JpaRepository<TodoHistory, Long> {
    List<TodoHistory> findByTodo_TodoId(Long todoId);
}