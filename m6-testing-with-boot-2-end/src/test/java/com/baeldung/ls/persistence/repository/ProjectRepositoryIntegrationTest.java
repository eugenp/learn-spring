package com.baeldung.ls.persistence.repository;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baeldung.ls.persistence.model.Project;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private IProjectRepository projectRepository;

    @Test
    public void givenNewProject_thenSavedSuccess() {
        Project newProject = new Project(1L, "First Project", LocalDate.now());
        assertNotNull(projectRepository.save(newProject));
    }

}
