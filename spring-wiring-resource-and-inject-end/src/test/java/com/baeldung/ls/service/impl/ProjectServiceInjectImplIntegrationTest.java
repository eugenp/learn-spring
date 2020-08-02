package com.baeldung.ls.service.impl;

import com.baeldung.ls.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProjectServiceInjectImplIntegrationTest {

    @Autowired
    private ProjectServiceInjectImpl projectService;

    @Test
    public void givenNewProject_thenSaveSuccess() {
        Project project = new Project("Rest with Spring", LocalDate.now());

        assertNotNull(projectService.save(project));
    }
}