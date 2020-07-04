package com.baeldung.ls.web.dto;

import java.util.HashSet;
import java.util.Set;

public class ProjectDto {

    private Long id;

    private String name;

    private Set<TaskDto> tasks;

    public ProjectDto() {
    }

    public ProjectDto(Long id, String name) {
        this.id = id;
        this.name = name;
        this.tasks = new HashSet<>();
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

    public Set<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskDto> tasks) {
        this.tasks = tasks;
    }

}
