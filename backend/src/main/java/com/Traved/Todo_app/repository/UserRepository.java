package com.Traved.Todo_app.repository;

import com.Traved.Todo_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}