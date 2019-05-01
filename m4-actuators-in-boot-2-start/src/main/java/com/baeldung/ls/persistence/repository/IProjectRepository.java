package com.baeldung.ls.persistence.repository;

import java.util.Optional;

import com.baeldung.ls.persistence.model.Project;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
