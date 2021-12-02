package com.baeldung.ls.persistence.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class BeanA {

    private String foo;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    private static final Logger LOG = LoggerFactory.getLogger(BeanA.class);

    @PostConstruct
    public void post() {
        LOG.info("value of the property foo is: {}", this.foo);
    }
}