package com.baeldung.ls.service.impl;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SimpleProjectServiceImpl implements IProjectService {

    private Map<Long, Project> projectMap = new HashMap<>();

    @Override
    public Optional<Project> findById(Long id) {
        return Optional.of(projectMap.get(id));
    }

    @Override
    public Project save(Project project) {
        projectMap.putIfAbsent(project.getId(), project);
        return project;
    }

    @Override
    public Iterable<Project> findAll() {
        return projectMap.values();
    }
}
