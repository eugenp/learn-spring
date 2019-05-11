package com.baeldung.ls.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.ls.persistence.model.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    IProjectRepository projectRepository;

    Project project1;
    Project project2;
    Project project3;
    Project project4;

    @BeforeEach
    public void beforeEach() {
        project1 = new Project(1L, "First Project", LocalDate.now());
        project2 = new Project(2L, "Second Project", LocalDate.now());
        project3 = new Project(3L, "Third Project", LocalDate.now());
        project4 = new Project(4L, "Fourth Project", LocalDate.now());

        projectRepository.save(project1);
        projectRepository.save(project2);
        projectRepository.save(project3);
        projectRepository.save(project4);
    }

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

    @Test
    public void givenProjectsCreated_thenFindAllPaginationSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2));

        assertThat(retrievedProjects.getContent()).contains(project1, project2);
        assertThat(retrievedProjects.getContent()).doesNotContain(project3, project4);
    }

    @Test
    public void givenProjectsCreated_thenFindAllSortSuccess() {
        Iterable<Project> retrievedProjects = projectRepository.findAll(Sort.by(Order.asc("name")));

        List<Project> projectList = new ArrayList<>();
        retrievedProjects.forEach(projectList::add);

        assertThat(projectList).containsSequence(project1, project4, project2, project3);
    }

    @Test
    public void givenProjectsCreated_thenFindAllPaginationAndSortSuccess() {
        Iterable<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2, Sort.by(Order.asc("name"))));

        List<Project> projectList = new ArrayList<>();
        retrievedProjects.forEach(projectList::add);

        assertThat(projectList).containsSequence(project1, project4);
    }
}