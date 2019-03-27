package com.baeldung.ls.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.baeldung.ls.persistence.dao.IProjectDao;
import com.baeldung.ls.persistence.model.Project;

@Component
public class ProjectDaoImpl implements IProjectDao {

    List<Project> projects = new ArrayList<>();

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Project save(Project project) {
        return findById(project.getId())
            .map(existingProject -> {
                projects.remove(existingProject);
                Project newProject = new Project(existingProject);
                projects.add(newProject);
                return newProject;
            })
            .orElseGet(() -> {
                projects.add(project);
                return project;
            });
    }

}
