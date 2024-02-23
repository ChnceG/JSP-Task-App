package com.example.model;

public class Todo {
    private int id;
    private String title;
    private String description;
    private String estimated;
    private boolean done;

    public Todo() {
    }

    public Todo(String title, String description, String estimated, boolean done) {
        this.title = title;
        this.description = description;
        this.estimated = estimated;
        this.done = done;
    }

    public Todo(int id, String title, String description, String estimated, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.estimated = estimated;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getEstimated() {
        return estimated;
    }

    public boolean isDone() {
        return done;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

