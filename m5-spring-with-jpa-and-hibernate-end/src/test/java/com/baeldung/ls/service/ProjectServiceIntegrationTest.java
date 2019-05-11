package com.baeldung.ls.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.ls.persistence.model.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceIntegrationTest {

    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private IProjectService projectService; 

    @Test
    public void whenContextIsLoaded1_thenNoExceptions() {
        System.out.println();
    }

    @Test
    public void givenNewProject_thenSavedSuccess() {
        Project newProject = new Project(null, "Project", LocalDate.now());
        assertThat(projectService.save(newProject)).isNotNull();
    }

    @Test
    public void givenProjectCreated_thenFindByIdSuccess() {
        Project newProject = new Project(null, "Another project", LocalDate.now());
        projectService.save(newProject);

        Optional<Project> retreivedProject = projectService.findById(newProject.getId());
        assertThat(retreivedProject.get()).isEqualTo(newProject);
    }
}