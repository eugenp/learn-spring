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

import com.baeldung.ls.persistence.dao.ITaskDao;
import com.baeldung.ls.persistence.model.Task;

@Repository
public class TaskDaoImpl implements ITaskDao {

    private static final Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Optional<Task> findById(Long id) {
        logger.info("find by id {}", id);
        Task item = em.find(Task.class, id);
        if (item == null) {
            logger.info("there is no task with id={}.", id);
        } else {
            logger.info(item.toString());
        }
        return item != null ? Optional.of(item) : Optional.empty();
    }

    @Transactional
    @Override
    public Task save(Task task) {
        em.persist(task);
        return task;
    }

    @Transactional
    @Override
    public List<Task> getAll() {
        Query query = em.createQuery("SELECT t FROM Task t");

        List<?> result = query.getResultList();
        if (result != null) {
            return result.stream()
                .map(i -> {
                    return (Task) i;
                })
                .collect(Collectors.toList());
        }
        return new ArrayList<>(0);
    }

}
