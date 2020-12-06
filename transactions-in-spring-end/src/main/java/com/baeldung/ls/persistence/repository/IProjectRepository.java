package com.baeldung.ls.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.baeldung.ls.persistence.model.Project;

public interface IProjectRepository extends CrudRepository<Project, Long> {
}
