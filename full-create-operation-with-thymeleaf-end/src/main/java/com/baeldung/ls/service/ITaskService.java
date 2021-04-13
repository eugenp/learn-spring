package com.baeldung.ls.service;

import java.util.Optional;

import com.baeldung.ls.persistence.model.Task;

public interface ITaskService {
    Optional<Task> findById(Long id);

    Task save(Task task);

}
