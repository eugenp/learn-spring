package com.baeldung.ls.web.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.baeldung.ls.web.dto.ProjectDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void mapperSetup() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
        writer = mapper.writerFor(ProjectDto.class);
    }

    @Test
    public void givenDefaultProjectsPersisted_whenCreateProject_thenEntityPersisted() throws Exception {
        this.mvc.perform(get("/projects/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(1)))
            .andExpect(jsonPath("$.name", is("Project 1")));
        this.mvc.perform(get("/projects/2"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(2)))
            .andExpect(jsonPath("$.name", is("Project 2")));
        this.mvc.perform(get("/projects/3"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(3)))
            .andExpect(jsonPath("$.name", is("Project 3")));
        this.mvc.perform(get("/projects/4"))
            .andExpect(status().isNotFound());

        ProjectDto newProject = new ProjectDto(null, "new project", LocalDate.now());
        this.mvc.perform(post("/projects").contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(newProject)))
            .andExpect(status().isOk())
            .andReturn();

        this.mvc.perform(get("/projects/4"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(4)))
            .andExpect(jsonPath("$.name", is("new project")));
    }

    private static String asJsonString(final Object obj) throws Exception {
        return writer.writeValueAsString(obj);
    }
}