package com.example.taskmanagement.taskmanagement_api.service;

import com.example.taskmanagement.taskmanagement_api.model.Task;
import com.example.taskmanagement.taskmanagement_api.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task();
        task.setTitle("Test Task");
        task.setDescription("This is a test task description");
        task.setDueDate(LocalDateTime.now().plusDays(1)); // Due tomorrow
    }

    @Test
    public void createTask_ShouldReturnCreatedTask() {
        // Arrange
        Task mockTask = task;
        when(taskRepository.save(any(Task.class))).thenReturn(mockTask);

        // Act
        Task createdTask = taskService.createTask(task);

        // Assert
        assertNotNull(createdTask, "Created task should not be null");
        assertEquals("Test Task", createdTask.getTitle(), "Task title should match");
        assertEquals("This is a test task description", createdTask.getDescription(), "Task description should match");
        assertTrue(createdTask.getDueDate().isAfter(LocalDateTime.now()), "Due date should be in the future");

        // Assert createdAt and updatedAt are not null and are recent
        assertNotNull(createdTask.getCreatedAt(), "CreatedAt timestamp should not be null");
        assertNotNull(createdTask.getUpdatedAt(), "UpdatedAt timestamp should not be null");
        assertTrue(createdTask.getCreatedAt().isBefore(LocalDateTime.now().plusSeconds(1)), "CreatedAt should be recent");
        assertTrue(createdTask.getUpdatedAt().isBefore(LocalDateTime.now().plusSeconds(1)), "UpdatedAt should be recent");

        // Verify that the save method was called once
        verify(taskRepository, times(1)).save(any(Task.class));
    }
}
