package com.baeldung.ls.persistence.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.baeldung.ls.exception.TaskNotAddedException;
import com.baeldung.ls.persistence.model.Task;
import com.baeldung.ls.persistence.repository.ITaskRepository;

@Repository
public class TaskRepositoryImpl implements ITaskRepository {

    private static final Logger LOG = LoggerFactory.getLogger(TaskRepositoryImpl.class);

    @Override
    public Task save(Task task) throws TaskNotAddedException {
        throw new TaskNotAddedException("Unable to add Task");
    }

}
