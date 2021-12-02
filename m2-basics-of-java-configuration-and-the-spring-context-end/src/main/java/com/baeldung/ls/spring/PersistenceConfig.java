package com.baeldung.ls.spring;

import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.service.impl.ProjectServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryImpl;

@Configuration
public class PersistenceConfig {

    @Bean
    public IProjectRepository projectRepository() {
        return new ProjectRepositoryImpl();
    }

    @Bean
    public ProjectServiceImpl projectService(IProjectRepository repository) {
        return new ProjectServiceImpl(repository);
    }

}
