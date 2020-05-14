package com.baeldung.ls.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {

    private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);

    @Autowired
    private Environment environment;

    @PostConstruct
    void post() {
        LOG.info("Active Profiles: {}", environment.getActiveProfiles());
        LOG.info("Default Profiles: {}", environment.getDefaultProfiles());
    }

    @Bean("beanA")
    @Profile("prod")
    BeanA prodBeanA() {
        LOG.info("Returning prodBeanA for prod profile");
        return new BeanA("prod");
    }

    @Bean("beanA")
    @Profile("dev")
    BeanA devBeanA() {
        LOG.info("Returning devBeanA for dev profile");
        return new BeanA("dev");
    }
}
