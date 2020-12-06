package com.baeldung.ls;

import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class LsAppConfig {

    @Bean
    @Scope("prototype")
    public IProjectRepository prototypeBean() {
        return new ProjectRepositoryImpl();
    }

}