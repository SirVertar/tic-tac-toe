package com.mateusz.jakuszko.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class PlayerCreator {
    private HumanPlayer humanPlayer1;
    private HumanPlayer humanPlayer2;
    private ComputerPlayer computerPlayer;
    private List<Player> listOfPlayers = new ArrayList<>();

    public PlayerCreator(HumanPlayer humanPlayer1, HumanPlayer humanPlayer2) {
        this.humanPlayer1 = humanPlayer1;
        this.humanPlayer2 = humanPlayer2;
        listOfPlayers.add(humanPlayer1);
        listOfPlayers.add(humanPlayer2);
    }

    public PlayerCreator(HumanPlayer humanPlayer1, ComputerPlayer computerPlayer) {
        this.humanPlayer1 = humanPlayer1;
        this.computerPlayer = computerPlayer;
        listOfPlayers.add(humanPlayer1);
        listOfPlayers.add(computerPlayer);
    }


    public void generateListOfPlayers() {
        listOfPlayers.add(humanPlayer1);
        if (humanPlayer2 != null) {
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

    public void setListOfPlayers(List<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }
}
