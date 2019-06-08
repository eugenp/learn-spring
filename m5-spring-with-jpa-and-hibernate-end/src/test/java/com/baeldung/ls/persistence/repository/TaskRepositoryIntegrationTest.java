package com.baeldung.ls.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.ls.persistence.model.Task;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskRepositoryIntegrationTest {

    @Autowired
    private ITaskRepository taskRepository;

    @Test
    public void givenNewTask_thenSavedSuccess() {
        Task task = new Task("Task", "task description", LocalDate.now(), LocalDate.now().plusDays(2));

        assertThat(taskRepository.save(task)).isNotNull();
    }

}
