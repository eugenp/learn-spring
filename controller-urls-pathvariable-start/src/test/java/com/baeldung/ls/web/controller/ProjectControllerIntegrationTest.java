package com.baeldung.ls.web.controller;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.baeldung.ls.web.dto.ProjectDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest
@AutoConfigureMockMvc
public class ProjectControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    private static ObjectWriter writer;
    private static ObjectReader reader;

    @BeforeAll
    public static void mapperSetup() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
        writer = mapper.writerFor(ProjectDto.class);
        reader = mapper.readerFor(ProjectDto.class);
    }

    @Test
    public void givenDefaultProjectsPersisted_whenRequestAllProjects_thenRetrieveListWithEntities() throws Exception {
        // @formatter:off
        this.mvc.perform(get("/projects"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))));
        // @formatter:on
    }

    @Test
    public void givenDefaultProjectsPersisted_whenRequestProjectById_thenRetrieveEntity() throws Exception {
        // @formatter:off
        this.mvc.perform(get("/projects/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(1)))
            .andExpect(jsonPath("$.name", is("Project 1")));
        // @formatter:on
    }

    @Test
    public void givenNewProject_whenCreateProject_thenGetEndpointRetrieveEntity() throws Exception {
        // @formatter:off
        ProjectDto newProject = new ProjectDto(3L, "new project", LocalDate.now());

        this.mvc.perform(post("/projects").
                contentType(MediaType.APPLICATION_JSON).
                content(asJsonString(newProject)))
            .andExpect(status().isCreated());
        
        this.mvc.perform(get("/projects/3"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(3)))
            .andExpect(jsonPath("$.name", is("new project")));
        // @formatter:on
    }

    @Test
    public void givenDefaultProjectsPersisted_whenUpdateProject_thenGetEndpointRetrieveEntity() throws Exception {
        // @formatter:off
        ProjectDto createdProject = createProject();
        ProjectDto updatedProject = new ProjectDto(createdProject.id(), "updated project", LocalDate.now());
        
        this.mvc.perform(put("/projects/" + createdProject.id()).
                contentType(MediaType.APPLICATION_JSON).
                content(asJsonString(updatedProject)))
            .andExpect(status().isOk());
        
        this.mvc.perform(get("/projects/" + createdProject.id()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(createdProject.id().intValue())))
            .andExpect(jsonPath("$.name", is("updated project")));
        // @formatter:on
    }

    @Test
    public void givenNewProject_whenDeleteProject_thenGetEntityRetrieves404() throws Exception {
        // @formatter:off
        ProjectDto createdProject = createProject();
        
        this.mvc.perform(delete("/projects/" + createdProject.id()))
            .andExpect(status().isNoContent());
        
        this.mvc.perform(get("/projects/" + createdProject.id()))
            .andExpect(status().isNotFound());
        // @formatter:on
    }

    private ProjectDto createProject() throws Exception {
        // @formatter:off
        ProjectDto newProject = new ProjectDto(null,
                "new project",
                LocalDate.now());
        MvcResult mvcResult = this.mvc.perform(post("/projects").
                contentType(MediaType.APPLICATION_JSON).
                content(asJsonString(newProject)))
            .andExpect(status().isCreated()).andReturn();
        
        ProjectDto createdProject = reader.readValue(mvcResult.getResponse().getContentAsByteArray());
        this.mvc.perform(get("/projects/" + createdProject.id()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(createdProject.id().intValue())))
            .andExpect(jsonPath("$.name", is("new project")));
        
        return createdProject;
        // @formatter:on
    }

    private static String asJsonString(final Object obj) throws Exception {
        return writer.writeValueAsString(obj);
    }

}
