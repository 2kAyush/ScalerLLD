package com.example.snakeandladder.models;

public class Dice {
    private int maxNo;
    Dice(int maxNo) {
        this.maxNo = maxNo;
    }
    public int roll(){
        return (int)(Math.random() * (this.maxNo - 1 + 1) + 1);
    }
}
