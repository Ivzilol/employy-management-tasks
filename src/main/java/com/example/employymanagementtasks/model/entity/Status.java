package com.example.employymanagementtasks.model.entity;

public enum Status {

    NOT_IN_PROGRESS ("Not in Progress"),
    IN_PROGRESS ("In progress"),
    COMPLETED ("Completed");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
