package com.baeldung.ls.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.baeldung.ls.persistence.model.Project;

public interface IListProjectRepository extends ListCrudRepository<Project, Long> {
}
