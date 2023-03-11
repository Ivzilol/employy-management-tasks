package com.example.employymanagementtasks.model.dto;

import com.example.employymanagementtasks.model.entity.TaskPriority;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AddTaskDTO {

    private Long id;

    @Size(min = 10, max = 30, message = "Description must be min 10 and max 30 symbols")
    @NotNull
    private String description;

    @Size(min = 5, max = 20, message = "Title must be min 5 and max 20 symbols")
    @NotNull
    private String title;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull
    private TaskPriority taskPriority;


    public AddTaskDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

}
