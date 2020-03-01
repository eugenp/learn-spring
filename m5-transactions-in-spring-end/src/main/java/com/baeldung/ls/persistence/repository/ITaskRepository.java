package com.baeldung.ls.persistence.repository;

import com.baeldung.ls.exception.TaskNotAddedException;
import com.baeldung.ls.persistence.model.Task;

public interface ITaskRepository {

    Task save(Task project) throws TaskNotAddedException;

}
