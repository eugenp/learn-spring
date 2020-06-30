package com.baeldung.ls.persistence.repository.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;

import javax.annotation.PostConstruct;

@Repository
public class ProjectRepositoryImpl implements IProjectRepository {

    private List<Project> projects = new ArrayList<>();

    @PostConstruct
    public void setup() {
        Project project = new Project(1L, "Spring Course", LocalDate.now());
        projects.add(project);
    }
    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream()
            .filter(p -> p.getId() == id)
            .findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        if (existingProject == null) {
            projects.add(project);
            return project;
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
            return project;
        }
    }

}
