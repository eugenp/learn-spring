package com.baeldung.ls.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.service.IProjectService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class ProjectServiceImpl implements IProjectService, ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private IProjectRepository projectRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        LOG.info("CONTEXT WITH ID '{}' SET", applicationContext.getId());
    }

    @PostConstruct
    public void created() {
        LOG.info("POST CONSTRUCT in ProjectServiceImpl");
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @PreDestroy
    public void onDestroy() {
        LOG.info("PRE DESTROY in ProjectServiceImpl");
    }
}
