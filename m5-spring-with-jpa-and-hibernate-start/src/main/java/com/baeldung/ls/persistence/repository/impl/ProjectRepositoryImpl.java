package com.baeldung.ls.persistence.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;

@Repository
public class ProjectRepositoryImpl implements IProjectRepository {

    @Override
    public Optional<Project> findById(Long id) {
        return null;
    }

    @Override
    public Project save(Project project) {
        return null;
    }

}
