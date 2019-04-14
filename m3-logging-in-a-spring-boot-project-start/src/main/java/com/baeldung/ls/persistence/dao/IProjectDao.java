package com.baeldung.ls.persistence.dao;

import java.util.Optional;

import com.baeldung.ls.persistence.model.Project;

public interface IProjectDao {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
