package com.baeldung.ls.web.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.baeldung.ls.persistence.model.Project;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProjectControllerEndToEndIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void givenDefaultProjectsPersisted_whenRequestAllProjects_thenRetrieveListWithEntities() throws Exception {
        ResponseEntity<Project[]> projectsResponse = this.restTemplate.getForEntity("/projects", Project[].class);

        assertThat(projectsResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(projectsResponse.getBody()).hasSizeGreaterThanOrEqualTo(2);
    }

    @Test
    public void whenCreateUsingXmlContentType_thenHandledResponseRetrieved() throws Exception {
        RequestEntity<Void> request = RequestEntity.post("/projects")
            .contentType(MediaType.APPLICATION_XML)
            .build();

        ResponseEntity<String> errorResponse = this.restTemplate.exchange(request, String.class);

        assertThat(errorResponse.getStatusCode()).isEqualTo(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        assertThat(errorResponse.getBody()).startsWith("Media Type not supported: ");
    }

    @Test
    public void whenGetNonExistingProject_thenGetEntityRetrieves4xxWithBootErrorFields() throws Exception {
        ParameterizedTypeReference<Map<String, String>> responseType = new ParameterizedTypeReference<>() {
        };
        RequestEntity<Void> request = RequestEntity.get("/projects/99")
            .accept(MediaType.APPLICATION_JSON)
            .build();

        ResponseEntity<Map<String, String>> errorResponse = this.restTemplate.exchange(request, responseType);

        assertThat(errorResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(errorResponse.getBody()).containsEntry("message", "Project not found");
    }

    @Test
    public void whenDeleteNonExistingProject_thenGetEntityRetrieves4xx() throws Exception {
        RequestEntity<Void> request = RequestEntity.delete("/projects/99")
            .accept(MediaType.APPLICATION_JSON)
            .build();

        ResponseEntity<String> errorResponse = this.restTemplate.exchange(request, String.class);

        assertThat(errorResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(errorResponse.getBody()).isEqualTo("Exception retrieving data: No class com.baeldung.ls.persistence.model.Project entity with id 99 exists");
    }

}
