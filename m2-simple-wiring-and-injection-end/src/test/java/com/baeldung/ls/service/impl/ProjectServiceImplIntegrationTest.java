package com.baeldung.ls.service.impl;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baeldung.ls.persistence.model.Project;

@SpringBootTest
public class ProjectServiceImplIntegrationTest {

    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    @Test
    public void givenNewProject_thenSavedSuccess() {
        Project newProject = new Project("First Project", LocalDate.now());

        assertNotNull(projectServiceImpl.save(newProject));
    }
}
