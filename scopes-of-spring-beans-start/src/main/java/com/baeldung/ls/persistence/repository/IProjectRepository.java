package com.baeldung.ls.persistence.repository;

import com.baeldung.ls.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
