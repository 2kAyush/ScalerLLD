package com.example.snakeandladder.models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private int finishedButtons;
    private List<Button> buttons;

    public Player(int id) {
        this.id = id;
        this.buttons = new ArrayList<>();
    }
    public void addButtons(int maxNoOfButton) {
        for(int i = 0; i < maxNoOfButton;i++){
            this.buttons.add(new Button());
        }
    }

    public int getId() {
        return id;
    }

    public int getFinishedButtons() {
        return finishedButtons;
    }

    public void increaseFinishedButtons() {
        this.finishedButtons++;
    }

    public List<Button> getButtons() {
        return this.buttons;
    }

}
