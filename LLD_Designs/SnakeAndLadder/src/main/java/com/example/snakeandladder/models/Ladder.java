package com.example.snakeandladder.models;

public class Ladder extends ForeignEntity{
    public Ladder(int from, int to, ForeignEntityType type) {
        super(from, type);
        this.setTo(to);
    }
}
