package com.mateusz.jakuszko.tictactoe;

public class PlayerCreator {
    private HumanPlayer humanPlayer1;
    private HumanPlayer humanPlayer2;
    private ComputerPlayer computerPlayer;

    public void createTwoHumanPlayers() {
        humanPlayer1 = new HumanPlayer();
        humanPlayer2 = new HumanPlayer();
        System.out.println(humanPlayer1.getName());
        System.out.println(humanPlayer2.getName());
    }

    public void createOnePlayerAndComputer(Board board) {
        humanPlayer1 = new HumanPlayer();
        System.out.println(humanPlayer1.getName());
        computerPlayer = new ComputerPlayer(board);
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
