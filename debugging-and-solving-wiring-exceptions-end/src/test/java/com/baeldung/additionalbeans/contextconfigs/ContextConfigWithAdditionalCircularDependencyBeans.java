package com.baeldung.additionalbeans.contextconfigs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.baeldung.ls", "com.baeldung.additionalbeans"})
public class ContextConfigWithAdditionalCircularDependencyBeans {

}
