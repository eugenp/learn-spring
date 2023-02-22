package com.baeldung.ls.persistence

import org.springframework.data.repository.CrudRepository
import java.time.LocalDate
import jakarta.persistence.*

@Entity
class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var name: String,
    var dateCreated: LocalDate?,
    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "project_id")
    var tasks: MutableSet<Task> = mutableSetOf(),
) {
    constructor(project: Project) : this(null, project.name, project.dateCreated, project.tasks)

    override fun toString(): String {
        return "Project [id=$id, name=$name, tasks=$tasks]\n"
    }
}

// repository
interface IProjectRepository : CrudRepository<Project, Long> 
