package com.baeldung.ls.persistence.repository;

import java.util.List;
import java.util.Optional;

import com.baeldung.ls.persistence.model.Task;

public interface ITaskRepository {
    Optional<Task> findById(Long id);

    Task save(Task task);

    List<Task> getAll();
}
