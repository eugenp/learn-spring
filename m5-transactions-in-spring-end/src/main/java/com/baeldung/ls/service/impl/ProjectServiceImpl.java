package com.baeldung.ls.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baeldung.ls.exception.TaskNotAddedException;
import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.model.Task;
import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.persistence.repository.ITaskRepository;
import com.baeldung.ls.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private IProjectRepository projectRepository;
    private ITaskRepository taskRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository, ITaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Transactional(rollbackOn = TaskNotAddedException.class)
    @Override
    public Project createProjectWithTasks() throws TaskNotAddedException {
        Project project = new Project("Project 1", LocalDate.now());

        LOG.info("Saving Project: {}", project);
        Project newProject = projectRepository.save(project);
        LOG.info("New Project Added: {}", project);
        
        Task task1 = new Task("Task 1", "Project 1 Task 1", LocalDate.now(), LocalDate.now()
            .plusDays(7));

        LOG.info("Saving Task: {}", task1);
        taskRepository.save(task1);

        return newProject;
    }

}
