package com.baeldung.ls.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {

    private final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

    public void before(String methodName) {
      LOG.info("before executing method: {}", methodName);
    }
}
