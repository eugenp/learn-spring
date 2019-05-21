package com.baeldung.ls.web.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    //

    @GetMapping(value = "/{id}")
    public Project findOne(@PathVariable Long id) {
        return this.projectService.findById(id).orElse(new Project(id,"TEST", LocalDate.now()));
    }

    @PostMapping
    public void create(@RequestBody Project newProject) {
        this.projectService.save(newProject);
    }

}
