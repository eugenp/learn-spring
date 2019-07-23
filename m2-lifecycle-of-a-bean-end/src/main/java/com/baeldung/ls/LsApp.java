package com.baeldung.ls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.baeldung.ls.config.AppConfig;

@SpringBootApplication
public class LsApp {

    public static void main(final String... args) {
        ConfigurableApplicationContext context = SpringApplication.run(new Class[] { LsApp.class, AppConfig.class }, args);
        context.close();
    }

}
