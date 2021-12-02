package com.baeldung.ls.spring;

import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryImpl;
import com.baeldung.ls.service.impl.ProjectServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestPersistenceConfig {

    @Bean
    public IProjectRepository projectRepository() {
        return new ProjectRepositoryImpl();
    }

    @Bean
    public ProjectServiceImpl projectService(IProjectRepository repository) {
        return new ProjectServiceImpl(repository);
    }

}
