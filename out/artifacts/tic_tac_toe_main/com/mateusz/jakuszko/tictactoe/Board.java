package com.mateusz.jakuszko.tictactoe;

import com.mateusz.jakuszko.tictactoe.buttons.GameButton;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private GameButton[][] boardButtons = createBoardButtons();
    private List<GameButton[]> winningTrios = createWinningTrios();
    private SceneChanger sceneChanger;
    private GameButton[] winningRow;

    Board(SceneChanger sceneChanger) {
        this.sceneChanger = sceneChanger;
    }

    private GameButton[][] createBoardButtons() {
        GameButton[][] temporaryButtons = new GameButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GameButton button = new GameButton(this);
                temporaryButtons[i][j] = button;
            }
        }
        return temporaryButtons;
    }


    private List<GameButton[]> createWinningTrios() {

        List<GameButton[]> winningTriosList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            GameButton[] temporaryTrio = new GameButton[3];
            temporaryTrio[0] = boardButtons[0][i];
            temporaryTrio[1] = boardButtons[1][i];
            temporaryTrio[2] = boardButtons[2][i];
            winningTriosList.add(temporaryTrio);

            GameButton[] temporaryTrio1 = new GameButton[3];
            temporaryTrio1[0] = boardButtons[i][0];
            temporaryTrio1[1] = boardButtons[i][1];
            temporaryTrio1[2] = boardButtons[i][2];
            winningTriosList.add(temporaryTrio1);
        }
        GameButton[] temporaryTrio2 = new GameButton[3];
        temporaryTrio2[0] = boardButtons[0][0];
        temporaryTrio2[1] = boardButtons[1][1];
        temporaryTrio2[2] = boardButtons[2][2];
        winningTriosList.add(temporaryTrio2);

        GameButton[] temporaryTrio3 = new GameButton[3];
        temporaryTrio3[0] = boardButtons[2][0];
        temporaryTrio3[1] = boardButtons[1][1];
        temporaryTrio3[2] = boardButtons[0][2];
        winningTriosList.add(temporaryTrio3);

        return winningTriosList;
    }

    public void whoWin() {
        boolean isWinner = false;
        for (GameButton[] buttons : winningTrios) {
            if (buttons[0].getValueOfButtonField() == buttons[1].getValueOfButtonField() &&
                    buttons[0].getValueOfButtonField() == buttons[2].getValueOfButtonField() &&
                    buttons[0].getValueOfButtonField() != -1 &&
                    buttons[1].getValueOfButtonField() != -1 &&
                    buttons[2].getValueOfButtonField() != -1) {
                winningRow = buttons;
                sceneChanger.addWinningText();
                blockAllButtons();
                if (buttons[0].getValueOfButtonField() == 0) {
                    sceneChanger.getPlayerCreator().getHumanPlayer1().addPoint();
                    changePlayersScoreLabels();
                } else if (buttons[0].getValueOfButtonField() == 1) {
                    if (sceneChanger.getPlayerCreator().getHumanPlayer2() != null) {
                        sceneChanger.getPlayerCreator().getHumanPlayer2().addPoint();
                        changePlayersScoreLabels();
                    } else {
                        sceneChanger.getPlayerCreator().getComputerPlayer().addPoint();
                        changePlayersScoreLabels();
                    }
                }
            }
        }
    }

    public void changePlayersScoreLabels() {
        sceneChanger.getPlayer1ScoreLabel().setText(sceneChanger.getPlayerCreator().getHumanPlayer1().getName() +
                ": " + sceneChanger.getPlayerCreator().getHumanPlayer1().getScore());
        if (sceneChanger.getPlayerCreator().getHumanPlayer2() != null) {
            sceneChanger.getPlayer2ScoreLabel().setText(sceneChanger.getPlayerCreator().getHumanPlayer2().getName() +
                    ": " + sceneChanger.getPlayerCreator().getHumanPlayer2().getScore());
        } else {
            sceneChanger.getPlayer2ScoreLabel().setText(sceneChanger.getPlayerCreator().getComputerPlayer().getName() +
                    ": " + sceneChanger.getPlayerCreator().getComputerPlayer().getScore());
        }
    }

    private void blockAllButtons() {
        for (GameButton[] buttonsAgain : winningTrios) {
            for (int i = 0; i < 3; i++) {
                buttonsAgain[i].setEmpty(false);
            }
        }
    }

    public SceneChanger getSceneChanger() {
        return sceneChanger;
    }

    public GameButton[][] getBoardButtons() {
        return boardButtons;
    }

    public List<GameButton[]> getWinningTrios() {
        return winningTrios;
    }
}
