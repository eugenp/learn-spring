package com.baeldung.ls.config;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;

import static org.assertj.core.api.Assertions.*;

class PersistenceConfigTest {

    private ApplicationContext springContext;

    @BeforeEach
    void setUp() {
        springContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);
    }

    @Test
    void testSpringContext() {
        final Project expected = new Project(1L, "first project", LocalDate.now());
        final IProjectService projectService = springContext.getBean(IProjectService.class);
        projectService.save(expected);

        Optional<Project> actual = projectService.findById(1L);

        assertThat(actual).isPresent();
        assertThat(actual.get())
                .isEqualToComparingFieldByField(expected);
    }
}
