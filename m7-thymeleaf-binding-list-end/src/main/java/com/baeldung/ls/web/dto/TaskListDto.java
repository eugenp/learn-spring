package com.baeldung.ls.web.dto;

import java.util.ArrayList;
import java.util.List;

public class TaskListDto {
    private List<TaskDto> tasks;

    public TaskListDto() {
        tasks = new ArrayList<>();
    }

    public TaskListDto(List<TaskDto> tasks) {
        this.tasks = tasks;
    }

    public void addTask(TaskDto task) {
        this.tasks.add(task);
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }

}
