package com.mateusz.jakuszko.tictactoe;

public class PlayerCreator {
    private HumanPlayer humanPlayer1;
    private HumanPlayer humanPlayer2;
    private ComputerPlayer computerPlayer;

    public void createTwoHumanPlayers(String name1, String name2) {
        humanPlayer1 = new HumanPlayer(name1);
        humanPlayer2 = new HumanPlayer(name2);
        System.out.println(humanPlayer1.getName());
        System.out.println(humanPlayer2.getName());
    }

    public void createOnePlayerAndComputer(String name1) {
        humanPlayer1 = new HumanPlayer(name1);
        System.out.println(humanPlayer1.getName());
        computerPlayer = new ComputerPlayer();
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


}
