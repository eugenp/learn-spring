package com.baeldung.ls.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baeldung.ls.persistence.dao.IProjectDao;
import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private IProjectDao projectDao;

    public ProjectServiceImpl(IProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.info("Project Service >> Finding Project By Id {}", id);
        return projectDao.findById(id);
    }

    @Override
    public Project save(Project project) {
        LOG.info("Project Service >> Saving Project", project);
        return projectDao.save(project);
    }

}
