package com.baeldung.ls.service;

import java.util.Optional;

import com.baeldung.ls.persistence.model.Project;

public interface IProjectService {
    Optional<Project> findById(Long id);

    Project save(Project project);

    Iterable<Project> findAll();

    void delete(Long id);

    Iterable<Project> findByName(String name);
}
