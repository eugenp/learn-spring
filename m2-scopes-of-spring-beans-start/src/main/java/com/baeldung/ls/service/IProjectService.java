package com.baeldung.ls.service;

import com.baeldung.ls.persistence.model.Project;

import java.util.Optional;

public interface IProjectService {
    Optional<Project> findById(Long id);

    Project save(Project project);
}
