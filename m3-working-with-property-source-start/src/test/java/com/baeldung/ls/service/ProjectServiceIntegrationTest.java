package com.baeldung.ls.service;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(value = TestConfig.class)
public class ProjectServiceIntegrationTest {

    @Autowired
    private IProjectService projectService;

    @Test
    public void whenSavingProject_thenOK() {
        Project savedProject = projectService.save(new Project("name", LocalDate.now()));
        assertNotNull(savedProject);
    }

}