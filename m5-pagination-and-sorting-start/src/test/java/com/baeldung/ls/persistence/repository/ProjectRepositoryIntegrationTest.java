package com.baeldung.ls.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.ls.persistence.model.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    IProjectRepository projectRepository;

    @Test
    public void givenNewProject_thenSavedSuccess() {
        Project newProject = new Project(1L, "First Project", LocalDate.now());
        assertThat(projectRepository.save(newProject)).isNotNull();
    }

    @Test
    public void givenProjectCreated_thenFindByIdSuccess() {
        Project newProject = new Project(1L, "First Project", LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retreivedProject = projectRepository.findById(1L);
        assertThat(retreivedProject.get()).isEqualTo(newProject);
    }

    @Test
    public void givenProjectCreated_thenFindByNameSuccess() {
        Project newProject = new Project(1L, "First Project", LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retreivedProject = projectRepository.findByName("First Project");
        assertThat(retreivedProject.get()).isEqualTo(newProject);
    }

    @Test
    public void givenProjectCreated_thenFindByDateCreatedBetweenSuccess() {
        Project oldProject = new Project(1L, "Old Project", LocalDate.now().minusYears(1));
        projectRepository.save(oldProject);

        Project newProject = new Project(2L, "New Project", LocalDate.now());
        projectRepository.save(newProject);

        Project newProject2 = new Project(3L, "New Project", LocalDate.now());
        projectRepository.save(newProject2);

        List<Project> retreivedProjects = projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertThat(retreivedProjects).contains(newProject, newProject2);
    }
}