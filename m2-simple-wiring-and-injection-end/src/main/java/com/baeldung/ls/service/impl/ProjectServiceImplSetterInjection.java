package com.baeldung.ls.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.baeldung.ls.persistence.dao.IProjectDao;
import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;

public class ProjectServiceImplSetterInjection implements IProjectService {

    private IProjectDao projectDao;

    @Override
    public Optional<Project> findById(Long id) {
        return projectDao.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectDao.save(project);
    }

    @Autowired
    public void setProjectDao(IProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public IProjectDao getProjectDao() {
        return projectDao;
    }
}
