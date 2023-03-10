package com.example.employymanagementtasks.model.dto;

import java.util.Set;

public class TaskByPriorityDTO {

    private Set<TaskDTO> Important;

    private Set<TaskDTO> Average;

    private Set<TaskDTO> Unimportant;

    public TaskByPriorityDTO() {
    }

    public Set<TaskDTO> getImportant() {
        return Important;
    }

    public void setImportant(Set<TaskDTO> important) {
        Important = important;
    }

    public Set<TaskDTO> getAverage() {
        return Average;
    }

    public void setAverage(Set<TaskDTO> average) {
        Average = average;
    }

    public Set<TaskDTO> getUnimportant() {
        return Unimportant;
    }

    public void setUnimportant(Set<TaskDTO> unimportant) {
        Unimportant = unimportant;
    }
}
