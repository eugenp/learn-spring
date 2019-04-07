package com.baeldung.ls;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baeldung.ls.persistence.dao.IProjectDao;
import com.baeldung.ls.persistence.dao.impl.ProjectDaoImpl;
import com.baeldung.ls.service.IProjectService;
import com.baeldung.ls.service.impl.ProjectServiceImplSetterInjection;

@Configuration
public class LsAppConfig {

    @Bean
    public IProjectDao projectDao() {
        return new ProjectDaoImpl();
    }

    @Bean
    public IProjectService projectServiceImplSetterInjection() {
        ProjectServiceImplSetterInjection projectServiceImplSetterInjection = new ProjectServiceImplSetterInjection();
        projectServiceImplSetterInjection.setProjectDao(projectDao());
        return projectServiceImplSetterInjection;
    }
}
