package com.baeldung.ls.contextconfigs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.baeldung.ls")
public class ContextConfigWithNoChanges {

}
