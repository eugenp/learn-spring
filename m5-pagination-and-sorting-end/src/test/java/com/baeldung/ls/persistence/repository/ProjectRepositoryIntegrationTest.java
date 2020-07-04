package com.baeldung.ls.persistence.repository;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.baeldung.ls.persistence.model.Project;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    IProjectRepository projectRepository;

    @Test
    public void givenDataCreated_whenFindAllPaginated_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2));

        assertThat(retrievedProjects.getContent(), hasSize(2));
    }

    @Test
    public void givenDataCreated_whenFindAllSort_thenSuccess() {
        List<Project> retrievedProjects = (List<Project>) projectRepository.findAll(Sort.by(Order.asc("name")));

        List<Project> sortedProjects = retrievedProjects.stream()
            .collect(Collectors.toList());
        sortedProjects.sort(Comparator.comparing(Project::getName));

        assertEquals(sortedProjects, retrievedProjects);
    }

    @Test
    public void givenDataCreated_whenFindAllPaginatedAndSort_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2, Sort.by(Order.asc("name"))));

        assertThat(retrievedProjects.getContent(), hasSize(2));
    }
}