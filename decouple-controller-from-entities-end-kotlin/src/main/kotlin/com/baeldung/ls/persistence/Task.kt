package com.baeldung.ls.persistence

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository
import java.time.LocalDate
import java.util.Optional;
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var name: String,
    var description: String?,
    var dateCreated: LocalDate?,
    var dueDate: LocalDate?,
    var status: TaskStatus? = TaskStatus.TO_DO,
) {
    constructor(task: Task) : this(null, task.name, task.description, task.dateCreated, task.dueDate)

    override fun toString(): String {
        return "Task [id=$id, name=$name, status=$status]\n"
    }
}

enum class TaskStatus(val label: String) {
    TO_DO("To Do"),
    IN_PROGRESS("In Progress"),
    ON_HOLD("On Hold"),
    DONE("Done"),
}

//repository
interface ITaskRepository : PagingAndSortingRepository<Task, Long>, CrudRepository<Task, Long> {
}
