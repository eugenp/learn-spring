package com.baeldung.ls.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private IProjectRepository projectRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Project Service >> Finding Project By Id {}", id);
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        LOG.debug("Project Service >> Saving Project", project);
        return projectRepository.save(project);
    }

}
