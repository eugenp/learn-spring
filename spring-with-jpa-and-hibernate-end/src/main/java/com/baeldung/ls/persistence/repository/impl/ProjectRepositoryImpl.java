package com.baeldung.ls.persistence.repository.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;

@Repository
public class ProjectRepositoryImpl implements IProjectRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Optional<Project> findById(Long id) {
        Project entity = em.find(Project.class, id);
        return Optional.ofNullable(entity);
    }

    @Transactional
    @Override
    public Project save(Project project) {
        em.persist(project);
        return project;
    }

}
