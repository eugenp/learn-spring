package com.baeldung.ls;

import java.time.LocalDate;
import java.util.Optional;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;

@SpringBootApplication
public class LsApp {

    @Autowired
    private IProjectService projectService;

    public static void main(final String... args) {
        SpringApplication.run(LsApp.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        Project project = new Project("My First Project", LocalDate.now());
        projectService.save(project);

        Optional<Project> optionalProject = projectService.findById(project.getId());
        optionalProject.ifPresent(System.out::println);
    }
}
