package com.baeldung.ls.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baeldung.ls.persistence.model.Task;
import com.baeldung.ls.persistence.repository.ITaskRepository;
import com.baeldung.ls.service.ITaskService;

@Service
public class TaskServiceImpl implements ITaskService {

    private ITaskRepository taskDao;

    public TaskServiceImpl(ITaskRepository taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskDao.findById(id);
    }

    @Override
    public Task save(Task task) {
        return taskDao.save(task);
    }

}
