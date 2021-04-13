package com.baeldung.ls;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class LsApp implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(LsApp.class);

    @Autowired
    private IProjectService projectService;

    public static void main(final String... args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(LsApp.class, args);
        LOG.info("APPLICATION STARTUP FINISHED");
    }

    @Override
    public void run(String... args) {
        projectService.save(new Project(1L,"Project 1", LocalDate.now()));

        Optional<Project> project = projectService.findById(1L);

        LOG.info("Project {}", project.toString());
    }
}
