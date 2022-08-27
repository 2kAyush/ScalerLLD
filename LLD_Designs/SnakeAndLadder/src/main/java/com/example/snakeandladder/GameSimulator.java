package com.example.snakeandladder;

import com.example.snakeandladder.controllers.GameController;
import com.example.snakeandladder.models.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameSimulator {
    public static void main(String[] args) {
        System.out.println("Snake and Ladders");
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);
        // we can take input for snakes and ladders or choose random positions for these entities.
        ForeignEntity snake1 = new Snake(98, 2, ForeignEntityType.SNAKES);
        ForeignEntity ladder1 = new Ladder(3, 95, ForeignEntityType.LADDERS);
        GameController gameController = new GameController();
        Game game = gameController.createGame(List.of(p1, p2, p3), List.of(snake1, ladder1));
        if(game == null){
            System.out.println("Can't create game");
            return ;
        }
        System.out.println("Starting the Game");
        gameController.setGameStatus(game, GameStatus.IN_PROGRESS);
        //Board board = game.getBoard();
        // HashMap<Integer, ForeignEntity> fEMap = board.getForeignEntityMap();
        // fEMap.entrySet().forEach(entry -> {
        //     ForeignEntity fE = entry.getValue();
        //     System.out.println(entry.getKey() + " " + fE.getFrom() + " " + fE.getTo() + " " + fE.getType());
        // });
        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            System.out.println("Next move");
            gameController.makeMove(game);
        }
        System.out.println("LeaderBoard: ");
        gameController.showLeaderBoard(game);
    }
}
