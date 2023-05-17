package com.baeldung.ls.web

import com.baeldung.ls.persistence.TaskStatus
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
    var dateCreated: LocalDate? = null,
    var dueDate: LocalDate? = null,
    var status: TaskStatus?,
)
