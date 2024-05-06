package com.model;

import java.util.UUID;

public class Task {

    private String id;
    private String description;
    private TaskStatus status;

    public Task(String description){
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.status = TaskStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
