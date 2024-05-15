package com.baeldung.ls.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {


    public WebSecurityConfig() {
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/login*", "/*css/**")
                .permitAll()
                .requestMatchers(HttpMethod.POST, "/projects")
                .hasRole("MANAGER")
                .anyRequest()
                .authenticated())
            .formLogin((form) -> form
                    .permitAll()
                    .defaultSuccessUrl("/projects"));
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user =  User.withUsername("user")
            .password(passwordEncoder.encode("password"))
            .roles("USER")
            .build();
        UserDetails manager =  User.withUsername("manager")
            .password(passwordEncoder.encode("password"))
            .roles("MANAGER")
            .build();
        return new InMemoryUserDetailsManager(user, manager);
    }

}