package com.baeldung.ls.service;

import java.util.List;
import java.util.Optional;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.model.Task;

public interface IProjectService {
    Optional<Project> findById(Long id);

    Project save(Project project);

    Iterable<Project> findAll();

    Project addTasks(Project project, List<Task> tasks);
}
