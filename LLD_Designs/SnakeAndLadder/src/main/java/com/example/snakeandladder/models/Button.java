package com.example.snakeandladder.models;

public class Button {
    private int position;
    private ButtonStatus buttonStatus;

    public Button() {
        this.position = 0;
        this.buttonStatus = ButtonStatus.LOCKED;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ButtonStatus getButtonStatus() {
        return buttonStatus;
    }

    public void setButtonStatus(ButtonStatus buttonStatus) {
        this.buttonStatus = buttonStatus;
    }
}
