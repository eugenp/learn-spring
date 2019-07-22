package com.baeldung.ls.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void givenNewTask_whenSaved_thenSuccess() {
        Task newTask = new Task("First Task", "First Task", LocalDate.now(), LocalDate.now());
        assertThat(taskRepository.save(newTask)).isNotNull();
    }

    @Test
    public void givenTaskCreated_whenFindById_thenSuccess() {
        Task newTask = new Task("First Task", "First Task", LocalDate.now(), LocalDate.now());
        taskRepository.save(newTask);

        Optional<Task> retreivedTask = taskRepository.findById(newTask.getId());
        assertThat(retreivedTask.get()).isEqualTo(newTask);
    }
}