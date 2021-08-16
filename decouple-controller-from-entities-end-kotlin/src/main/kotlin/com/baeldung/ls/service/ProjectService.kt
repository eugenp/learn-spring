package com.baeldung.ls.service

import com.baeldung.ls.persistence.IProjectRepository
import com.baeldung.ls.persistence.Project
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

interface IProjectService {
    fun findById(id: Long): Project?
    fun save(project: Project): Project
}

@Service
class ProjectServiceImpl(private val projectRepository: IProjectRepository) : IProjectService {
    override fun findById(id: Long): Project? = projectRepository.findByIdOrNull(id)
    override fun save(project: Project): Project =
        project.let {
            if (it.id == null) it.dateCreated = LocalDate.now()
            projectRepository.save(it)
        }
}

