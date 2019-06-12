package com.baeldung.ls.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baeldung.ls.persistence.model.Task;

@SpringBootTest
public class TaskRepositoryIntegrationTest {

    @Autowired
    ITaskRepository taskRepository;

    @Test
    public void whenSavingNewTask_thenSuccess() {
        Task newTask = new Task("First Task", "First Task", LocalDate.now(), LocalDate.now());
        assertNotNull(taskRepository.save(newTask));
    }

    @Test
    public void givenTask_whenFindById_thenSuccess() {
        Task newTask = new Task("First Task", "First Task", LocalDate.now(), LocalDate.now());
        taskRepository.save(newTask);

        Optional<Task> retreivedTask = taskRepository.findById(newTask.getId());
        assertEquals(retreivedTask.get(), newTask);
    }
}