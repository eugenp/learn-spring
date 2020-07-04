package com.baeldung.ls.config;

import com.baeldung.ls.service.impl.SimpleProjectServiceProxy;

public class CustomBeanFactory {

    public static Object getBean(String beanName) {
        if ("projectService".equalsIgnoreCase(beanName)) {
            return new SimpleProjectServiceProxy();
        }
        return null;
    }
}
