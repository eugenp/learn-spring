package com.baeldung.ls.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class PersistenceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:learn-spring-db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        return dataSource;
    }

    /* MySQL DataSource bean
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/learn-spring-db");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        return dataSource;
    }*/
}
