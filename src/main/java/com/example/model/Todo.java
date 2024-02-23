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
}

