package com.baeldung.ls.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class ProjectServiceIntegrationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void whenContextIsLoaded1_thenNoExceptions() {
        System.out.println();
    }

    @Test
    public void whenContextIsLoaded2_thenNoExceptions() {
        System.out.println();
    }
}