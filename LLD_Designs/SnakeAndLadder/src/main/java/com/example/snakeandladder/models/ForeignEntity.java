package com.example.snakeandladder.models;

public abstract class ForeignEntity {
    private int from;
    private int to;
    private ForeignEntityType type;

    public int getFrom() {
        return this.from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public ForeignEntityType getType() {
        return type;
    }

    public ForeignEntity(int from, ForeignEntityType type) {
        this.from = from;
        this.type = type;
    }
}
