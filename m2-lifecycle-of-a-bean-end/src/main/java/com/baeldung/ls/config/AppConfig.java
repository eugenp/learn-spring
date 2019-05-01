package com.baeldung.ls.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baeldung.ls.persistence.model.BeanA;
import com.baeldung.ls.persistence.model.BeanB;
import com.baeldung.ls.persistence.model.BeanC;

@Configuration
public class AppConfig {
    
    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean(initMethod="initialize")
    public BeanB beanB() {
        return new BeanB();
    }
    
    @Bean(destroyMethod="destroy")
    public BeanC beanC() {
        return new BeanC();
    }

    
}
