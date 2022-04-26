package com.baeldung.ls.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;

@SpringBootTest
class ProjectServiceIntegrationTest {
    @Autowired
    private IProjectService projectService;

    @Test
    public void givenNewProject_whenSaved_thenSuccess() {
        Project newProject = new Project("First Project", LocalDate.now());
        assertNotNull(projectService.save(newProject));
    }
}