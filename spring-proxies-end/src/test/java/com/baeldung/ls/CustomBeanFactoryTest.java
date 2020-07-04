package com.baeldung.ls;

import com.baeldung.ls.config.CustomBeanFactory;
import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CustomBeanFactoryTest {

    @Test
    void whenCustomBeanFactoryIsInvoked_thenReturnsProjectServiceBean() {
        Object bean = CustomBeanFactory.getBean("projectService");
        assertTrue(bean instanceof IProjectService);

        IProjectService projectService = (IProjectService) bean;
        assertNotNull(projectService.save(new Project("project1", LocalDate.now())));
    }
}
