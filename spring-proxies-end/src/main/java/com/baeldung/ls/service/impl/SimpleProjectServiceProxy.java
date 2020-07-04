package com.baeldung.ls.service.impl;

import com.baeldung.ls.aspect.LoggingAspect;
import com.baeldung.ls.persistence.model.Project;

public class SimpleProjectServiceProxy extends SimpleProjectServiceImpl {

    @Override
    public Project save(Project project) {
        new LoggingAspect().before("save()");
        return super.save(project);
    }
}
