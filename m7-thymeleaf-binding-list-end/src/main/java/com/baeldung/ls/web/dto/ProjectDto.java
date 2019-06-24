package com.baeldung.ls.web.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ProjectDto {

    private Long id;

    private String name;

    private LocalDate dateCreated;

    private Set<TaskDto> tasks;

    public ProjectDto() {
    }

    public ProjectDto(Long id, String name, LocalDate dateCreated) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        tasks = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Set<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskDto> tasks) {
        this.tasks = tasks;
    }

}
