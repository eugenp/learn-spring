package com.baeldung.ls;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

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
    void postConstruct() {
        projectService.save(new Project("First Project", LocalDate.now()));
        projectService.save(new Project("Second Project", LocalDate.now()));
        projectService.save(new Project("Third Project", LocalDate.now()));
        projectService.save(new Project("Fourth Project", LocalDate.now()));
    }

}
