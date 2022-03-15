package com.baeldung.ls.service.impl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.ls.exception.TaskNotSavedException;
import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.model.Task;
import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.service.IProjectService;
import com.baeldung.ls.service.ITaskService;

@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepository;
    private ITaskService taskService;

    public ProjectServiceImpl(IProjectRepository projectRepository, ITaskService taskService) {
        this.projectRepository = projectRepository;
        this.taskService = taskService;
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

    @Transactional(rollbackFor = TaskNotSavedException.class)
    @Override
    public void createProjectWithTasks() throws TaskNotSavedException {
        Project project = new Project("Project 1", LocalDate.now());

        Project newProject = save(project);

        Task task1 = new Task("Task 1", "Project 1 Task 1", LocalDate.now(), LocalDate.now()
            .plusDays(7));

        taskService.save(task1);

        Set<Task> tasks = new HashSet<>();
        tasks.add(task1);

        newProject.setTasks(tasks);

        save(newProject);
    }

}
