package com.baeldung.ls.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.baeldung.ls.persistence.model.Task;

public interface ITaskRepository extends CrudRepository<Task, Long> {
}
