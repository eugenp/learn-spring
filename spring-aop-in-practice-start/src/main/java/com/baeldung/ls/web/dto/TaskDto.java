package com.baeldung.ls.web.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.baeldung.ls.persistence.model.TaskStatus;

public record TaskDto(
    Long id,
    String name,
    String description,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateCreated,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate,
    TaskStatus status) {
}