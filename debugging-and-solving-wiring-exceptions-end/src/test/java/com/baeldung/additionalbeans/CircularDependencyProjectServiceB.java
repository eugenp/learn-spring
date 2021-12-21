package com.baeldung.additionalbeans;

import org.springframework.stereotype.Service;

@Service
public class CircularDependencyProjectServiceB {

    private CircularDependencyProjectServiceA projectServiceA;

    public CircularDependencyProjectServiceB(CircularDependencyProjectServiceA projectServiceA) {
        this.projectServiceA = projectServiceA;
    }
}
