package com.baeldung.ls.persistence.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.ls.persistence.model.Task;
import com.baeldung.ls.persistence.repository.ITaskRepository;

@Repository
public class TaskRepositoryImpl implements ITaskRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Optional<Task> findById(Long id) {
        Task item = em.find(Task.class, id);
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
        TypedQuery<Task> query = em.createQuery("SELECT * FROM Task", Task.class);
        return query.getResultList();
    }

}
