package com.baeldung.ls.persistence.model;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanA {

    private static Logger log = LoggerFactory.getLogger(BeanA.class);

    @PostConstruct
    public void post() {
        log.info("@PostConstruct annotated method is called.");
    }
}
