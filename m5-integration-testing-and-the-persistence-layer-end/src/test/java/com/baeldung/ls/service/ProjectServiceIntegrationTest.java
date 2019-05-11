package com.baeldung.ls.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baeldung.ls.persistence.model.Project;

@SpringBootTest
public class ProjectServiceIntegrationTest {

    @Autowired
    IProjectService projectService;

    @Test
    public void givenNewProject_thenSavedSuccess() {
        Project newProject = new Project(1L, "First Project", LocalDate.now());
        assertThat(projectService.save(newProject)).isNotNull();
    }

    @Test
    public void givenProjectCreated_thenFindByIdSuccess() {
        Project newProject = new Project(1L, "First Project", LocalDate.now());
        projectService.save(newProject);

        Optional<Project> retreivedProject = projectService.findById(1L);
        assertThat(retreivedProject.get()).isEqualTo(newProject);
    }
}