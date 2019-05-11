package com.baeldung.ls.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.model.Task;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceIntegrationTest {

    @Autowired
    private ITaskService taskService;

    @Autowired
    private IProjectService projectService; 

    @Test
    public void givenNewTask_thenSavedSuccess() {
        Task newTask = new Task(null, "Task", "task description", LocalDate.now(), LocalDate.now()
            .plusDays(2));
        assertThat(taskService.save(newTask)).isNotNull();
    }

    @Test
    public void givenProjectHasTasks_thenItPersistsAfterSaving() {
        Project project = new Project(null, "project with a task", LocalDate.now());
        Task task = new Task(null, "task", "description of task", LocalDate.now(), LocalDate.now()
            .plusDays(1));
        project.addTask(task);
        projectService.save(project);
        task.setProject(project);
        taskService.save(task);

        Optional<Project> retreivedProject = projectService.findById(project.getId());
        Set<Task> projectTasks = new HashSet<Task>(Arrays.asList(task));
        assertEquals(retreivedProject.get().getTasks(), projectTasks);
    }
}