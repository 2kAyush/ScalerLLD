package com.example.snakeandladder.strategies.movestrategies;

import com.example.snakeandladder.models.Board;
import com.example.snakeandladder.models.Player;
import com.example.snakeandladder.strategies.startstrategies.CanStartStrategy;

public interface MakeMoveStrategy {
    void makeMove(Player player, int value, Board board, CanStartStrategy canStartStrategy);
}
