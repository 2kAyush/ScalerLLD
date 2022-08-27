package com.example.snakeandladder.controllers;

import com.example.snakeandladder.models.ForeignEntity;
import com.example.snakeandladder.models.Game;
import com.example.snakeandladder.models.GameStatus;
import com.example.snakeandladder.models.Player;

import java.util.List;

public class GameController {
    public Game createGame(List<Player> players, List<ForeignEntity> foreignEntities){
        if(players.size() < 2) {
            System.out.println("Minimum 2 players are required");
            return null;
        }
        System.out.println(players.size());
        Game game = null;
        try {
            game = Game.create()
                    .setBoard(100)
                    .setDice(6)
                    .setPlayers(players)
                    .setTotalButtonPerPlayer(2)
                    .setForeignEntities(foreignEntities)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return game;
    }

    public void makeMove(Game game) {
        game.makeMove();
    }
    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }
    public void setGameStatus(Game game, GameStatus gameStatus){
        game.setGameStatus(gameStatus);
    }
    public void showLeaderBoard(Game game) {
        for(Player player:game.getLeaderBoard()){
            System.out.println(player.getId());
        }
    }
}
