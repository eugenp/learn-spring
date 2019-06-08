package com.baeldung.ls.persistence.repository;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
public class ProjectRepositoryIntegrationTest {

    @Autowired
    IProjectRepository projectRepository;

    @Test
    public void whenSavingNewProject_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());

        assertNotNull(projectRepository.save(newProject));
    }

    @Test
    public void givenProject_whenFindById_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retreivedProject = projectRepository.findById(newProject.getId());

        assertEquals(retreivedProject.get(), newProject);
    }

    @Test
    public void givenProjectHasTasks_thenTheyPersistsAfterSaving() {
        Project project = new Project("project with tasks", LocalDate.now());
        Task task1 = new Task("task 1", "description of task 1", LocalDate.now(), LocalDate.now().plusDays(1));
        Task task2 = new Task("task 2", "description of task 2", LocalDate.now(), LocalDate.now().plusDays(2));

        project.addTask(task1);
        project.addTask(task2);
        projectRepository.save(project);

        Optional<Project> retreivedProject = projectRepository.findById(project.getId());
        Set<Task> projectTasks = new HashSet<Task>(Arrays.asList(task1, task2));
        assertEquals(retreivedProject.get().getTasks(), projectTasks);
    }

    @Test
    public void givenProjectHasTasks_thenTaksHaveReferencesToProject() {
        Project project = new Project("project with a task", LocalDate.now());
        Task task1 = new Task("task", "description of the task", LocalDate.now(), LocalDate.now().plusDays(1));

        project.addTask(task1);
        projectRepository.save(project);

        Optional<Project> retreivedProject = projectRepository.findById(project.getId());

        assertEquals(1, retreivedProject.get().getTasks().size());
        List<Task> tasks = new ArrayList<Task>(retreivedProject.get().getTasks());

        assertEquals(project, tasks.get(0).getProject());

    }
}
