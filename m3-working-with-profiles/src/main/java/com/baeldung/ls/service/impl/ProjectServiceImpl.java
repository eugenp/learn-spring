package com.baeldung.ls.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baeldung.ls.persistence.dao.IProjectDao;
import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectDao projectDao;

    public ProjectServiceImpl(IProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectDao.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectDao.save(project);
    }

}
