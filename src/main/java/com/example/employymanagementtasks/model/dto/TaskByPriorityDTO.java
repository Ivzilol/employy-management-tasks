package com.example.employymanagementtasks.model.dto;

import java.util.Set;

public class TaskByPriorityDTO {

    private Set<TaskDTO> important;

    private Set<TaskDTO> average;

    private Set<TaskDTO> unimportant;

    public TaskByPriorityDTO() {
    }

    public Set<TaskDTO> getImportant() {
        return important;
    }

    public void setImportant(Set<TaskDTO> important) {
        this.important = important;
    }

    public Set<TaskDTO> getAverage() {
        return average;
    }

    public void setAverage(Set<TaskDTO> average) {
        this.average = average;
    }

    public Set<TaskDTO> getUnimportant() {
        return unimportant;
    }

    public void setUnimportant(Set<TaskDTO> unimportant) {
        this.unimportant = unimportant;
    }


}
