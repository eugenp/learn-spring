package com.baeldung.ls.web

import com.baeldung.ls.web.JsonWriter.asJsonString
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import java.text.SimpleDateFormat
import java.time.LocalDate

@SpringBootTest
@AutoConfigureMockMvc
class ProjectControllerIntegrationTest(@Autowired val mvc: MockMvc) {

    @Test
    fun `When application starts Then default projects should be persisted`() {
        (1..3).forEach {
            mvc.get("/projects/$it").andExpect {
                status { isOk() }
                jsonPath("$.id") { Matchers.`is`(it) }
                jsonPath("$.name") { Matchers.`is`("Project $it") }
            }
        }
    }

    @Test
    fun `When creating new project Then new project should be saved in database`() {
        mvc.get("/projects/4").andExpect {
            status { isNotFound() }
        }

        val newProject = ProjectDto(null, "new project", LocalDate.now())
        mvc.post("/projects") {
            contentType = MediaType.APPLICATION_JSON
            content = asJsonString(newProject)
        }.andExpect {
            status { isOk() }
        }.andReturn()

        mvc.get("/projects/4").andExpect {
            status { isOk() }
            jsonPath("$.id") { Matchers.`is`(4) }
            jsonPath("$.name") { Matchers.`is`("new project") }
        }
    }
}

object JsonWriter {
    private val mapper = jacksonObjectMapper().apply {
        registerModule(JavaTimeModule())
        disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        dateFormat = SimpleDateFormat("dd-MM-yyyy")
    }

    fun asJsonString(obj: Any): String =
        mapper.writerFor(ProjectDto::class.java).writeValueAsString(obj)
}