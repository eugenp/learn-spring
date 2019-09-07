package com.baeldung.ls.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenDefaultProjectsPersisted_whenRequestAllProjects_thenRetrieveListWithEntities() throws Exception {
        // @formatter:off
        this.mvc.perform(get("/projects"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))));
        // @formatter:on
    }

    @SuppressWarnings("unchecked")
    @Test
    public void givenPathVariablesWithRegexValue_whenRequestEndpointUsingRegex_thenAttributesParsedCorrectly() throws Exception {
        // @formatter:off
        MvcResult result = this.mvc.perform(get("/projects/categoryA-32/1")).andReturn();
        Map<String, String> attributes = (Map<String, String>)result.getRequest().getAttribute("org.springframework.web.servlet.HandlerMapping.uriTemplateVariables");
        assertThat(attributes).containsEntry("category", "categoryA").containsEntry("subcategoryId", "32").containsEntry("id", "1");
        // @formatter:on
    }
}
