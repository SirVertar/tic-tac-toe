package com.mateusz.jakuszko.tictactoe;

import com.mateusz.jakuszko.tictactoe.buttons.GameButton;

import java.util.ArrayList;
import java.util.List;

import static com.mateusz.jakuszko.tictactoe.buttons.GameButton.numberOfMove;

public class Board {

    private GameButton[][] boardButtons;
    private List<GameButton[]> winningTrios;
    private SceneChanger sceneChanger;

    Board(SceneChanger sceneChanger) {
        this.sceneChanger = sceneChanger;
        boardButtons = createBoardButtons(sceneChanger.getSizeOfGame());
        winningTrios = createWinningTrios(sceneChanger.getSizeOfGame());
    }

    private GameButton[][] createBoardButtons(int number) {
        GameButton[][] temporaryButtons = new GameButton[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                GameButton button = new GameButton(this, number);
                temporaryButtons[i][j] = button;
            }
        }
        return temporaryButtons;
    }

    private List<GameButton[]> createWinningTrios(int number) {

        List<GameButton[]> winningTriosList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number - 2; j++) {
                GameButton[] temporaryTrio = new GameButton[3];
                temporaryTrio[0] = boardButtons[j][i];
                temporaryTrio[1] = boardButtons[j + 1][i];
                temporaryTrio[2] = boardButtons[j + 2][i];
                winningTriosList.add(temporaryTrio);

                GameButton[] temporaryTrio1 = new GameButton[3];
                temporaryTrio1[0] = boardButtons[i][j];
                temporaryTrio1[1] = boardButtons[i][j + 1];
                temporaryTrio1[2] = boardButtons[i][j + 2];
                winningTriosList.add(temporaryTrio1);
            }
        }
        for (int i = 0; i < number - 2; i++) {
            GameButton[] temporaryTrio2 = new GameButton[3];
            temporaryTrio2[0] = boardButtons[i][i];
            temporaryTrio2[1] = boardButtons[i + 1][i + 1];
            temporaryTrio2[2] = boardButtons[i + 2][i + 2];
            winningTriosList.add(temporaryTrio2);

            GameButton[] temporaryTrio3 = new GameButton[3];
            temporaryTrio3[0] = boardButtons[number - 1 - i][i];
            temporaryTrio3[1] = boardButtons[number - 2 - i][i + 1];
            temporaryTrio3[2] = boardButtons[number - 3 - i][i + 2];
            winningTriosList.add(temporaryTrio3);
        }

        if (number > 3) {
            for (int i = 0; i < number - 3; i++) {
                for (int j = 0; j < number - 3; j++) {
                    if (j <= i) {
                        GameButton[] temporaryTrio1 = new GameButton[3];
                        temporaryTrio1[0] = boardButtons[2 - j + i][j];
                        temporaryTrio1[1] = boardButtons[1 - j + i][j + 1];
                        temporaryTrio1[2] = boardButtons[0 - j + i][j + 2];
                        winningTriosList.add(temporaryTrio1);

                        GameButton[] temporaryTrio2 = new GameButton[3];
                        temporaryTrio2[0] = boardButtons[number - 1 - j][number - 3 - i + j];
                        temporaryTrio2[1] = boardButtons[number - 2 - j][number - 2 - i + j];
                        temporaryTrio2[2] = boardButtons[number - 3 - j][number - 1 - i + j];
                        winningTriosList.add(temporaryTrio2);

                        GameButton[] temporaryTrio3 = new GameButton[3];
                        temporaryTrio3[0] = boardButtons[j][number - 3 - i + j];
                        temporaryTrio3[1] = boardButtons[1 + j][number - 2 - i + j];
                        temporaryTrio3[2] = boardButtons[2 + j][number - 1 - i + j];
                        winningTriosList.add(temporaryTrio3);

                        GameButton[] temporaryTrio4 = new GameButton[3];
                        temporaryTrio4[0] = boardButtons[number - 3 - i + j][0 + j];
                        temporaryTrio4[1] = boardButtons[number - 2 - i + j][1 + j];
                        temporaryTrio4[2] = boardButtons[number - 1 - i + j][2 + j];
                        winningTriosList.add(temporaryTrio4);
                    }
                }
            }
        }

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
                blockAllButtons();
                isWinner = true;
                if (buttons[0].getValueOfButtonField() == 0) {
                    sceneChanger.getPlayerCreator().getHumanPlayer1().addPoint();
                    changePlayersScoreLabels();
                    sceneChanger.addWinningLabel(sceneChanger.getPlayerCreator().getHumanPlayer1().getName());
                    break;
                } else if (buttons[0].getValueOfButtonField() == 1) {
                    if (sceneChanger.getPlayerCreator().getHumanPlayer2() != null) {
                        sceneChanger.getPlayerCreator().getHumanPlayer2().addPoint();
                        changePlayersScoreLabels();
                        sceneChanger.addWinningLabel(sceneChanger.getPlayerCreator().getHumanPlayer2().getName());
                        break;
                    } else {
                        sceneChanger.getPlayerCreator().getComputerPlayer().addPoint();
                        changePlayersScoreLabels();
                        sceneChanger.addWinningLabel("Computer");
                        break;
                    }
                }
            }
        }
        if (numberOfMove == (sceneChanger.getSizeOfGame()) * (sceneChanger.getSizeOfGame()) && !isWinner) {
            sceneChanger.addWinningLabel("Nobody");
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
