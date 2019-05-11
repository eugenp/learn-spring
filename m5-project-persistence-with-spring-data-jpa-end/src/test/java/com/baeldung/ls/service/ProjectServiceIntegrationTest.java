package com.baeldung.ls.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baeldung.ls.persistence.model.Project;

@SpringBootTest
public class ProjectServiceIntegrationTest {

    @Autowired
    private IProjectService projectService;

    @Test
    public void givenNewProject_thenSavedSuccess() {
        Project newProject = new Project(1l, "First Project", LocalDate.now());

        assertThat(projectService.save(newProject), is(notNullValue()));
    }

    @Test
    public void givenProjectCreated_whenFindById_thenSuccess() {
        Project newProject = new Project(1l, "First Project", LocalDate.now());

        projectService.save(newProject);

        Optional<Project> retrievedProject = projectService.findById(1l);
        assertThat(retrievedProject.get(), is(equalTo(newProject)));
    }

}