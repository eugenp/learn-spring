package com.baeldung.ls.persistence.dao;

import java.util.List;
import java.util.Optional;

import com.baeldung.ls.persistence.model.Task;

public interface ITaskDao {
    Optional<Task> findById(Long id);

    Task save(Task task);

    List<Task> getAll();
}
