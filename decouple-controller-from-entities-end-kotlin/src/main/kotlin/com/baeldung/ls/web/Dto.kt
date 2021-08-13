package com.baeldung.ls.web

import com.baeldung.ls.persistence.TaskStatus
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

class ProjectDto(
    var id: Long? = null,
    var name: String,
    var dateCreated: LocalDate? = null,
    var tasks: MutableSet<TaskDto> = mutableSetOf(),
)

class TaskDto(
    var id: Long? = null,
    var name: String,
    var description: String? = null,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    var dateCreated: LocalDate? = null,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    var dueDate: LocalDate? = null,
    var status: TaskStatus?,
)
