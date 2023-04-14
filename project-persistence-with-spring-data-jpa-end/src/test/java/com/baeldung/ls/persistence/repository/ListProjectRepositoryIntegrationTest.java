package com.baeldung.ls.persistence.repository;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baeldung.ls.persistence.model.Project;

@SpringBootTest
public class ListProjectRepositoryIntegrationTest {

    @Autowired
    IListProjectRepository listProjectRepository;

    @Test
    public void whenSavingNewProject_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());

        assertNotNull(listProjectRepository.save(newProject));
    }

    @Test
    public void givenProject_whenFindById_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        listProjectRepository.save(newProject);

        Optional<Project> retreivedProject = listProjectRepository.findById(newProject.getId());

        assertEquals(retreivedProject.get(), newProject);
    }

    @Test
    public void testFindAllWithListCrudRepository() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        listProjectRepository.save(newProject);
        List<Project> projects = listProjectRepository.findAll();
        assertTrue(projects.size() >= 2);
    }

}