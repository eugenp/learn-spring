package com.baeldung.ls;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baeldung.ls.service.IProjectService;
import com.baeldung.ls.service.impl.ProjectServiceImplSetterInjection;

@Configuration
public class LsAppConfig {

    @Bean
    public IProjectService projectServiceImplSetterInjection() {
        return new ProjectServiceImplSetterInjection();
    }
}
