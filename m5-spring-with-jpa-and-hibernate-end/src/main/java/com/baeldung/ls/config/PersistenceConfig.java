package com.baeldung.ls.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

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

    //  MySQL DataSource bean
    /*@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/learn-spring-db");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource);
      em.setPackagesToScan("com.baeldung.ls.persistence.model");


      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);

      Properties properties = new Properties();
      properties.setProperty("hibernate.hbm2ddl.auto", "update");
      em.setJpaProperties(properties);

      return em;
    }*/
}
