package com.baeldung.ls.web

import com.baeldung.ls.persistence.Project
import com.baeldung.ls.persistence.Task
import com.baeldung.ls.service.IProjectService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping(value = ["/projects"])
class ProjectController(private val projectService: IProjectService) {

    @GetMapping(value = ["/{id}"])
    fun findOne(@PathVariable id: Long): ProjectDto =
        projectService.findById(id)?.convertToDto() ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @PostMapping
    fun create(@RequestBody newProject: ProjectDto) {
        projectService.save(newProject.convertToEntity())
    }
}

private fun Project.convertToDto(): ProjectDto =
    ProjectDto(id, name, dateCreated).also { projectDto ->
        projectDto.tasks = tasks.map { it.convertToDto() }.toMutableSet()
    }

private fun Task.convertToDto(): TaskDto = TaskDto(id, name, description, dateCreated, dueDate, status)

private fun ProjectDto.convertToEntity(): Project = Project(id, name, dateCreated)

