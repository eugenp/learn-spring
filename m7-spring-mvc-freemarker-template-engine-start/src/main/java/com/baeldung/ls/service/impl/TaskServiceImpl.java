package com.baeldung.ls.service.impl;

import java.util.Optional;

import com.baeldung.ls.persistence.model.Task;
import com.baeldung.ls.persistence.repository.ITaskRepository;
import com.baeldung.ls.service.ITaskService;

public class TaskServiceImpl implements ITaskService {
    private ITaskRepository taskRepository;

    public TaskServiceImpl(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task project) {
        return taskRepository.save(project);
    }
}
