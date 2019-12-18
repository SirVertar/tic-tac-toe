package com.mateusz.jakuszko.tictactoe;

public class ComputerPlayer extends Player {

    private static final long serialVersionUID = 544107355449529730L;
    private int id = 2;

    public ComputerPlayer() {
        this.setName("Computer");
        System.out.println("Constructor ComputerPlayer");
    }

    @Override
    public int getId() {
        return id;
    }
}
