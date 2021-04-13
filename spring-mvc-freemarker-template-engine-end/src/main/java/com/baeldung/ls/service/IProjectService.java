package com.baeldung.ls.service;

import java.util.Optional;

import com.baeldung.ls.persistence.model.Project;

public interface IProjectService {
    Optional<Project> findById(Long id);

    Iterable<Project> findAll();

    Project save(Project project);
}
