package com.baeldung.ls.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;

@Configuration
public class MustacheViewResolverConfig {

    @Bean
    public ViewResolver getViewResolver(ResourceLoader resourceLoader) {
        MustacheViewResolver mustacheViewResolver = new MustacheViewResolver();
        mustacheViewResolver.setPrefix("classpath:/templates/mustache/");        
        mustacheViewResolver.setSuffix(".mustache");
        mustacheViewResolver.setCache(false);
        mustacheViewResolver.setOrder(2);
        return mustacheViewResolver;
    }

}