package com.baeldung.ls;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class WebSecurityIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @WithAnonymousUser()
    @Test
    public void when_unAuthenticatedUser_findAllProjects_thenLoginRedirect() throws Exception {
        this.mockMvc.perform(get("/projects"))
            .andDo(print())
            .andExpect(status().is3xxRedirection())
            .andExpect(header().stringValues("Location", "http://localhost/login"));
    }

    @WithMockUser(roles = "USER")
    @Test
    public void when_userWithRoleUSER_createProject_thenReturnForbidden() throws Exception {
        this.mockMvc.perform(post("/projects"))
            .andDo(print())
            .andExpect(status().isForbidden());
    }

    @WithMockUser(roles = "MANAGER")
    @Test
    public void when_userWithRoleManager_createProject_thenReturnOK() throws Exception {
        this.mockMvc.perform(post("/projects").with(csrf())
            .content("{\"name\" : \"new project\"}"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @WithMockUser(roles = "USER")
    @Test
    public void when_userWithRoleUSER_findAllProjects_thenReturnForbidden() throws Exception {
        this.mockMvc.perform(get("/projects"))
            .andDo(print())
            .andExpect(status().isForbidden());
    }

    @WithMockUser(roles = "MANAGER")
    @Test
    public void when_userWithRoleManager_findAllProjects_thenReturnOK() throws Exception {
        this.mockMvc.perform(get("/projects"))
            .andDo(print())
            .andExpect(status().isOk());
    }
}
