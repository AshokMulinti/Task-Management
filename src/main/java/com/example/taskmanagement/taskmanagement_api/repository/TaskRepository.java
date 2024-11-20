package com.example.taskmanagement.taskmanagement_api.repository;

import com.example.taskmanagement.taskmanagement_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
