package com.example.taskmanagement.taskmanagement_api.service;

import com.example.taskmanagement.taskmanagement_api.model.Task;
import com.example.taskmanagement.taskmanagement_api.repository.TaskRepository;
import com.example.taskmanagement.taskmanagement_api.exception.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        return taskRepository.findById(id).map(existingTask -> {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setDueDate(task.getDueDate());
            existingTask.setStatus(task.getStatus());
            existingTask.setUpdatedAt(LocalDateTime.now());  // Ensure updatedAt is updated
            return taskRepository.save(existingTask);
        }).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task markTaskAsComplete(Long id) {
        return taskRepository.findById(id).map(task -> {
            task.setStatus(Task.Status.COMPLETED);
            task.setUpdatedAt(LocalDateTime.now());  // Ensure updatedAt is updated
            return taskRepository.save(task);
        }).orElseThrow(() -> new TaskNotFoundException(id));
    }
}
