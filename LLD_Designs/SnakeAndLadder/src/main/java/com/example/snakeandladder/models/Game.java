package com.example.snakeandladder.models;

import com.example.snakeandladder.strategies.movestrategies.MakeMoveStrategy;
import com.example.snakeandladder.strategies.movestrategies.NormalMakeMoveStrategy;
import com.example.snakeandladder.strategies.startstrategies.CanStartStrategy;
import com.example.snakeandladder.strategies.startstrategies.NormalCanStartStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private Dice dice;
    private List<Player> players;// done
    private int totalButtonPerPlayer;// done
    private GameStatus gameStatus;
    private List<Player> leaderBoard;
    private int moveIndex;
    private MakeMoveStrategy makeMoveStrategy;
    private CanStartStrategy canStartStrategy;

    public void makeMove(){
        System.out.println("Rolling the dice");
        int dice_val = this.dice.roll();
        System.out.println("Got " + dice_val);
        while(this.players.get(moveIndex).getFinishedButtons() == this.totalButtonPerPlayer){
            moveIndex ++;
            moveIndex %= this.players.size();
        }
        System.out.println("moveIndex: " + moveIndex);
        makeMoveStrategy.makeMove(this.players.get(moveIndex), dice_val, this.board, this.canStartStrategy);
        // current moveIndex will be at position who hasn't won yet
        for(Button button:this.players.get(moveIndex).getButtons()){
            System.out.println(button.getPosition());
        }
        if(this.players.get(moveIndex).getFinishedButtons() == this.totalButtonPerPlayer){
            leaderBoard.add(this.players.get(moveIndex));
        }
        if(this.leaderBoard.size() == this.players.size() - 1){
            this.gameStatus = GameStatus.COMPLETED;
            for(Player player: this.players){
                if(player.getFinishedButtons() < this.totalButtonPerPlayer)
                    this.leaderBoard.add(player);
            }
        }
        moveIndex ++;
        moveIndex %= this.players.size();
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getLeaderBoard() {
        return leaderBoard;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void updateGameStatus(){
        if(this.leaderBoard.size() == players.size() - 1) {
            this.gameStatus = GameStatus.COMPLETED;
        }
    }
    public static Builder create() {
        return new Builder();
    }
    private Game() {
        this.gameStatus = GameStatus.NOT_STARTED;
        this.leaderBoard = new ArrayList<>();
        this.moveIndex = 0;
        this.makeMoveStrategy = new NormalMakeMoveStrategy();
        this.canStartStrategy = new NormalCanStartStrategy();
    }

    public static class Builder{
        private int maxDiceNumber;
        private List<Player> players;
        private List<ForeignEntity> foreignEntities;
        private int totalButtonPerPlayer;
        private Dice dice;
        private Board board;

        Builder() {
            this.players = new ArrayList<>();
            this.foreignEntities = new ArrayList<>();
            this.maxDiceNumber = 6;
            this.totalButtonPerPlayer = 1;
            this.board = new Board(100);
            this.dice = new Dice(6);
        }

        public Builder setBoard(int boardSize) {
            this.board = new Board(boardSize);
            return this;
        }

        public Builder setForeignEntities(List<ForeignEntity> foreignEntities) {
            this.foreignEntities = foreignEntities;
            return this;
        }

        public Game build(){
            Game game = new Game();
            for(Player player:this.players){
                player.addButtons(this.totalButtonPerPlayer);
            }
            game.players = this.players;
            game.totalButtonPerPlayer = this.totalButtonPerPlayer;
            this.board.addForeignEntities(foreignEntities);
            game.dice = this.dice;
            game.board = this.board;
            return game;
        }

        public Builder setDice(int maxDiceNumber) {
            this.dice = new Dice(maxDiceNumber);
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder addPlayer(Player player){
            this.players.add(player);
            return this;
        }

        public Builder setTotalButtonPerPlayer(int totalButtonPerPlayer) {
            this.totalButtonPerPlayer = totalButtonPerPlayer;
            return this;
        }
    }
}
