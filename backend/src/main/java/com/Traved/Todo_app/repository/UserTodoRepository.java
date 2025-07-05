package com.Traved.Todo_app.repository;

import com.Traved.Todo_app.model.UserTodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTodoRepository extends JpaRepository<UserTodo, Long> {
}