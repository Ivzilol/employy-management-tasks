package com.example.employymanagementtasks.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Table
@Entity
public class Tasks extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, name = "start_date")
    private LocalDate startDate;

    @Column(nullable = false, name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_types_of_tasks")
    private TypesOfTasks typesOfTasks;

    @ManyToMany(mappedBy = "tasks")
    private Set<Employees> employees;

    public Tasks() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setTypesOfTasks(TypesOfTasks typesOfTasks) {
        this.typesOfTasks = typesOfTasks;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }

    public TypesOfTasks getTypesOfTasks() {
        return typesOfTasks;
    }

    public Set<Employees> getEmployees() {
        return employees;
    }
}
