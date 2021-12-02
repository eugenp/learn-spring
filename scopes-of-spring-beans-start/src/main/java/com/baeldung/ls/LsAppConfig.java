package com.baeldung.ls;

import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class LsAppConfig {

    @Bean
    @Scope("singleton") //bean scope is singleton by default. This declaration is redundant.
    public IProjectRepository singletonBean() {
        return new ProjectRepositoryImpl();
    }

}