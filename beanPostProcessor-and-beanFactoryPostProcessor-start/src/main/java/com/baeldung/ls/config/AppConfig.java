package com.baeldung.ls.config;

import com.baeldung.ls.persistence.model.BeanA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

}
