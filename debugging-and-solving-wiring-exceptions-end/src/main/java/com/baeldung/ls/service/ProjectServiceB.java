package com.baeldung.ls.service;

import org.springframework.stereotype.Service;

@Service
public class ProjectServiceB {

    private ProjectServiceA projectServiceA;

    public ProjectServiceB(ProjectServiceA projectServiceA) {
        this.projectServiceA = projectServiceA;
    }
}
