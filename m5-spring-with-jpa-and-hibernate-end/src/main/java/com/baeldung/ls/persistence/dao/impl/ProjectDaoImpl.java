package com.baeldung.ls.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.ls.persistence.dao.IProjectDao;
import com.baeldung.ls.persistence.model.Project;

@Repository
public class ProjectDaoImpl implements IProjectDao {

    private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Optional<Project> findById(Long id) {
        Project item = em.find(Project.class, id);
        if (item == null) {
            logger.info("there is no project with id={}.", id);
        } else {
            logger.info(item.toString());
        }
        return item != null ? Optional.of(item) : Optional.empty();
    }

    @Transactional
    @Override
    public Project save(Project project) {
        em.persist(project);
        return project;
    }

    @Transactional
    @Override
    public List<Project> getAll() {
        Query query = em.createQuery("SELECT p FROM Project p");

        List<?> result = query.getResultList();
        if (result != null) {
            return result.stream()
                .map(i -> {
                    return (Project) i;
                })
                .collect(Collectors.toList());
        }
        return new ArrayList<>(0);
    }

}
