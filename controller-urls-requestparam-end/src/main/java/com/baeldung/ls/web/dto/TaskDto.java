package com.baeldung.ls.web.dto;

import java.time.LocalDate;

import com.baeldung.ls.persistence.model.TaskStatus;

public record TaskDto(
    Long id,
    String name,
    String description,
    LocalDate dateCreated,
    LocalDate dueDate,
    TaskStatus status) {
}
