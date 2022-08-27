package com.example.snakeandladder.models;

public class Snake extends ForeignEntity{
    public Snake(int from, int to, ForeignEntityType type) {
        super(from, type);
        this.setTo(to);
    }
}
