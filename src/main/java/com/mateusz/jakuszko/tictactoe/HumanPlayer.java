package com.mateusz.jakuszko.tictactoe;

public class HumanPlayer extends Player {

    private static final long serialVersionUID = -6242288266799114304L;
    private static int id = 1;

    HumanPlayer() {
        System.out.println("Constructor HumanPlayer");
    }

    @Override
    public int getId() {
        return id;
    }
}
