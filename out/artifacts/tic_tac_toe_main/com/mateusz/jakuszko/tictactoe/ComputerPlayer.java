package com.mateusz.jakuszko.tictactoe;

import java.io.Serializable;

public class ComputerPlayer extends Player  {


    private static final long serialVersionUID = 544107355449529730L;

    ComputerPlayer(Board board) {
        this.setName("Computer");
        System.out.println("Constructor ComputerPlayer");
    }


}
