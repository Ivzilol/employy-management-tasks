package com.example.employymanagementtasks.model.entity;

public enum TaskPriority {

    IMPORTANT ("Important"),

    AVERAGE ("Average"),

    UNIMPORTANT ("Unimportant");

    private final String value;

    TaskPriority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
