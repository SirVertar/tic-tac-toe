package com.mateusz.jakuszko.tictactoe;

import java.awt.event.MouseEvent;

public class ComputerPlayer extends Player {

    private Board board;

    public ComputerPlayer(Board board) {
        this.board = board;
        this.setName("Computer");
        System.out.println("Constructor ComputerPlayer");
    }

    public void makeMove() {
        board.getBoardButtons()[1][1].fire();
    }


}
