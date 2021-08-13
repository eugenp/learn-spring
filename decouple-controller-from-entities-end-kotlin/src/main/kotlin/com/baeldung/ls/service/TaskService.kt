package com.baeldung.ls.service

import com.baeldung.ls.persistence.ITaskRepository
import com.baeldung.ls.persistence.Task
import org.springframework.stereotype.Service
import java.util.*

interface ITaskService {
    fun findById(id: Long): Optional<Task>
    fun save(project: Task): Task
}

@Service
class TaskServiceImpl(private val taskRepository: ITaskRepository) : ITaskService {
    override fun findById(id: Long): Optional<Task> = taskRepository.findById(id)
    override fun save(project: Task): Task = taskRepository.save(project)
}