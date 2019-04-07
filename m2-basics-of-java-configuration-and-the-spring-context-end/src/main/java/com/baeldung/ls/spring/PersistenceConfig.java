package com.baeldung.ls.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baeldung.ls.persistence.dao.impl.ProjectDaoImpl;

@Configuration
public class PersistenceConfig {

    @Bean
    public ProjectDaoImpl projectDao() {
        return new ProjectDaoImpl();
    }

}
