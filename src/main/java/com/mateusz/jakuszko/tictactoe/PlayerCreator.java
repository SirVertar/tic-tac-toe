package com.mateusz.jakuszko.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class PlayerCreator {
    private HumanPlayer humanPlayer1;
    private HumanPlayer humanPlayer2;
    private ComputerPlayer computerPlayer;
    private List<Player> listOfPlayers = new ArrayList<>();

    public void createTwoHumanPlayers() {
        humanPlayer1 = new HumanPlayer();
        humanPlayer2 = new HumanPlayer();
        listOfPlayers.add(humanPlayer1);
        listOfPlayers.add(humanPlayer2);

    }

    public void createOnePlayerAndComputer(Board board) {
        humanPlayer1 = new HumanPlayer();
        computerPlayer = new ComputerPlayer(board);
        listOfPlayers.add(humanPlayer1);
        listOfPlayers.add(computerPlayer);
    }

    public void generateListOfPlayers() {
        listOfPlayers.add(humanPlayer1);
        if(computerPlayer == null) {
            listOfPlayers.add(humanPlayer2);
        } else {
            listOfPlayers.add(computerPlayer);
        }
    }


    public HumanPlayer getHumanPlayer1() {
        return humanPlayer1;
    }

    public HumanPlayer getHumanPlayer2() {
        return humanPlayer2;
    }

    public ComputerPlayer getComputerPlayer() {
        return computerPlayer;
    }

    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setHumanPlayer1(HumanPlayer humanPlayer1) {
        this.humanPlayer1 = humanPlayer1;
    }

    public void setHumanPlayer2(HumanPlayer humanPlayer2) {
        this.humanPlayer2 = humanPlayer2;
    }

    public void setComputerPlayer(ComputerPlayer computerPlayer) {
        this.computerPlayer = computerPlayer;
    }
}
