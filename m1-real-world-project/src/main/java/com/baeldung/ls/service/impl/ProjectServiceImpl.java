package com.baeldung.ls.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baeldung.ls.persistence.dao.IProjectDao;
import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;

@Component
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectDao projectDao;

    public ProjectServiceImpl() {
    }

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

    public IProjectDao getProjectDao() {
        return projectDao;
    }

    public void setProjectDao(IProjectDao projectDao) {
        this.projectDao = projectDao;
    }

}
