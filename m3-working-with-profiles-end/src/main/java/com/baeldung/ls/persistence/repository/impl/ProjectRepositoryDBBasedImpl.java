package com.baeldung.ls.persistence.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;

@Profile("prod")
@Repository
public class ProjectRepositoryDBBasedImpl implements IProjectRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectRepositoryDBBasedImpl.class);

    private List<Project> projects = new ArrayList<>();

    public ProjectRepositoryDBBasedImpl() {
        super();
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.info("Retrieving Project using ProjectRepositoryDBBasedImpl");
        return projects.stream()
            .filter(p -> p.getId() == id)
            .findFirst();
    }

    @Override
    public Project save(Project project) {
        LOG.info("Saving Project using ProjectRepositoryDBBasedImpl");
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
