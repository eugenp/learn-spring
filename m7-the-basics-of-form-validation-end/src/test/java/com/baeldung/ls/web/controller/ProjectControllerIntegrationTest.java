package com.baeldung.ls.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.baeldung.ls.service.IProjectService;

@WebMvcTest
public class ProjectControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IProjectService projectService;

    @Test
    public void whenFormWithMissingField_thenErrorTriggered() throws Exception {
        mockMvc.perform(post("/projects").param("name", ""))
            .andExpect(view().name("new-project"))
            .andExpect(model().attributeHasFieldErrors("project", "name"));
    }

}
