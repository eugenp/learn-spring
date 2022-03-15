package com.baeldung.ls.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELBeanA {

    @Value("#{2+3}")
    private Integer add;

    @Value("#{'Learn ' + 'Spring'}")
    private String addString;

    @Value("#{2 == 2}")
    private boolean equal;

    @Value("#{3 > 2 ? 'a' : 'b'}")
    private String ternary;

    @Value("#{spELBeanB.prop1}")
    private String otherBeanProperty;

}
