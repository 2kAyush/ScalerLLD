package com.example.snakeandladder.strategies.movestrategies;

import com.example.snakeandladder.models.Board;
import com.example.snakeandladder.models.Button;
import com.example.snakeandladder.models.ButtonStatus;
import com.example.snakeandladder.models.Player;
import com.example.snakeandladder.strategies.startstrategies.CanStartStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NormalMakeMoveStrategy implements MakeMoveStrategy{
    public void makeMove(Player player, int value, Board board, CanStartStrategy canStartStrategy){
        boolean canStart = canStartStrategy.canStart(value);
        int valid_ctr = 0;
        int locked_ctr = 0;
        for(Button button:player.getButtons()){
            System.out.println("Position: " + button.getPosition());
            if(button.getPosition() + value <= board.getSize()){
                valid_ctr++;
            }
            if(button.getButtonStatus() == ButtonStatus.LOCKED){
                locked_ctr++;
            }
        }
        if(valid_ctr == 0){
            System.out.println("OOPS you can't move");
            return;
        }
        if(locked_ctr == player.getButtons().size() && !canStart){
            System.out.println("all your buttons are locked and you did not got the number which can get your button out");
            return ;
        }
        System.out.println("You have your active buttons at these positions:");
        for(Button button:player.getButtons()){
            if(button.getButtonStatus() != ButtonStatus.FINISHED)
                System.out.println(button.getPosition());
        }
        System.out.println("Enter for which position you want to make the move");
        Scanner sc = new Scanner(System.in);
        Button toMoveButton = null;
        while(toMoveButton == null) {
            int position = sc.nextInt();
            for(Button button:player.getButtons()){
                if(button.getPosition() == position){
                    toMoveButton = button;
                    break;
                }
            }
            if(toMoveButton.getButtonStatus() == ButtonStatus.LOCKED){
                if(canStartStrategy.canStart(value)){
                    toMoveButton.setButtonStatus(ButtonStatus.IN_GAME);
                    // if for value = 6 we just want to get the button to 1 position and not to 6 we can here only set the value = 1
                    break;
                }
                toMoveButton = null;
            }
            if(toMoveButton == null){
                System.out.println("Invalid button please choose a correct one");
            }
            else if(toMoveButton.getPosition() + value > board.getSize()){
                System.out.println("Can't move this because it is > than the size");
            }
        }
        toMoveButton.setPosition(toMoveButton.getPosition() + value);
        if(toMoveButton.getPosition() == board.getSize()){
            toMoveButton.setButtonStatus(ButtonStatus.FINISHED);
            player.increaseFinishedButtons();
        }
        if(board.getForeignEntityMap().containsKey(toMoveButton.getPosition())){
            toMoveButton.setPosition(board.getForeignEntityMap().get(toMoveButton.getPosition()).getTo());
        }
    }
}
