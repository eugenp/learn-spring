package com.baeldung.ls.aspect;

import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.baeldung.ls.persistence.model.Project;

@Aspect
@Component
public class ProjectServiceAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceAspect.class);

    @Before("execution(* com.baeldung.ls.service.impl.ProjectServiceImpl.findById(Long))")
    public void before(JoinPoint joinPoint) {
        LOG.info("Searching Project with Id {}", joinPoint.getArgs()[0]);
    }

    @After("within(com.baeldung.ls.service.impl.ProjectServiceImpl)")
    public void afterAllMethodsOfProjectServiceImpl(JoinPoint joinPoint) {
        LOG.info("After invoking the method: {} ", joinPoint.getSignature()
            .getName());
    }

    @AfterReturning(pointcut = "execution(*..Optional<*..Project> *..service..findById(*))", returning = "project")
    public void afterReturningProject(Optional<Project> project) {
        LOG.info("project found: {}", project.orElse(null));
    }

    @Around("execution(* com.baeldung.ls.service.impl.ProjectServiceImpl.save(*))")
    public Object aroundSave(ProceedingJoinPoint joinPoint) {
        Object val = joinPoint.getArgs()[0];
        try {
            LOG.info("saving project : {}", val);
            val = joinPoint.proceed();
            LOG.info("project saved successfully !!");
        } catch (Throwable e) {
            LOG.error("error while saving project: ", e);
        }
        return val;
    }
}