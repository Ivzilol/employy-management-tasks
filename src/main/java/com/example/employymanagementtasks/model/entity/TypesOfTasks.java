package com.example.employymanagementtasks.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class TypesOfTasks extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private TaskPriority taskPriority;

    @Column
    private String Description;

    @OneToMany(mappedBy = "typesOfTasks", fetch = FetchType.EAGER)
    private Set<Tasks> tasks;

    public TypesOfTasks() {
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public Set<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Tasks> tasks) {
        this.tasks = tasks;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
