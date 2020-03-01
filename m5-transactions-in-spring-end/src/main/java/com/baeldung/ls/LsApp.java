package com.baeldung.ls;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baeldung.ls.service.IProjectService;

@SpringBootApplication
public class LsApp {

    private static final Logger LOG = LoggerFactory.getLogger(LsApp.class);

    @Autowired
    IProjectService projectService;

    public static void main(final String... args) {
        SpringApplication.run(LsApp.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        try {
            projectService.createProjectWithTasks();
        } catch (Exception e) {
            LOG.error("Error occurred in creating project with tasks", e);
        }
        LOG.info("Fetching all Projects");
        projectService.findAll()
            .forEach(p -> LOG.info(p.toString()));
    }

}
