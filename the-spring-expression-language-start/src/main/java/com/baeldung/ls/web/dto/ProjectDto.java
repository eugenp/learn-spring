package com.baeldung.ls.web.dto;

import java.time.LocalDate;
import java.util.Set;

public record ProjectDto(
    Long id,
    String name,
    LocalDate dateCreated,
    Set<TaskDto> tasks) {

    public ProjectDto (Long id, String name, LocalDate dateCreated) {
        this(id, name, dateCreated, null);
    }
}