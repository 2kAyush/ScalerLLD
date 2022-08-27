package com.example.snakeandladder.strategies.startstrategies;

public class NormalCanStartStrategy implements CanStartStrategy{
    @Override
    public boolean canStart(int value) {
        System.out.println("start strategy: " + value);
        return (value == 1 || value == 6);
    }
}
