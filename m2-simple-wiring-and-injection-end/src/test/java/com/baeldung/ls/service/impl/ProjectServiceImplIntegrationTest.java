package com.baeldung.ls.service.impl;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.ls.persistence.model.Project;

@RunWith(SpringRunner.class)
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
