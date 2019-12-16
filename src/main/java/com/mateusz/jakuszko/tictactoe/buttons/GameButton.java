package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.Board;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.Random;

public class GameButton extends Button {

    private Image circle = new Image("file:resources/circle.jpg");
    private Image xImage = new Image("file:resources/cross.jpg");
    private boolean isEmpty = true;
    public static int numberOfMove = 0;
    private int valueOfButtonField = -1;
    private Board board;
    private Background defaultBackGroundButton;
    private int sizeOfGame;


    public GameButton(Board board, int sizeOfGame) {
        this.sizeOfGame = sizeOfGame;
        this.board = board;
        this.setPrefSize(450 / sizeOfGame, 450 / sizeOfGame);
        Image gameButtonImage = new Image("file:resources/puste.jpg");
        defaultBackGroundButton = new Background(new BackgroundImage(gameButtonImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true)));
        this.setBackground(defaultBackGroundButton);
        this.setOnAction(event -> {
            if (numberOfMove % 2 == 0 && isEmpty) {
                numberOfMove++;
                isEmpty = false;
                setX();
            } else if (numberOfMove % 2 != 0 && isEmpty) {
                numberOfMove++;
                isEmpty = false;
                setY();
            }
        });
    }

    private void setX() {
        BackgroundImage backgroundCircle = new BackgroundImage(xImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true));
        this.setBackground(new Background(backgroundCircle));
        valueOfButtonField = 0;
        board.whoWin();
        boolean isComputerAlreadyMove = false;

        Random random = new Random();
        if (board.getSceneChanger().getPlayerCreator().getComputerPlayer() != null && numberOfMove < (sizeOfGame * sizeOfGame - 1)) {
            for (GameButton[] trio : board.getWinningTrios()) {
                int counterO = 0;
                for (int i = 0; i < 3; i++) {
                    if (trio[i].getValueOfButtonField() == 1) {
                        counterO++;
                    }
                }
                if (counterO == 2 && !isComputerAlreadyMove) {
                    for (int i = 0; i < 3; i++) {
                        if (trio[i].getValueOfButtonField() == -1) {
                            isComputerAlreadyMove = true;
                            trio[i].fire();
                        }
                    }
                }
            }
        }
        if (board.getSceneChanger().getPlayerCreator().getComputerPlayer() != null && numberOfMove < (sizeOfGame * sizeOfGame - 1)) {
            for (GameButton[] trio : board.getWinningTrios()) {
                int counterX = 0;
                for (int i = 0; i < 3; i++) {
                    if (trio[i].getValueOfButtonField() == 0) {
                        counterX++;
                    }
                }
                if (counterX == 2 && !isComputerAlreadyMove) {
                    for (int i = 0; i < 3; i++) {
                        if (trio[i].getValueOfButtonField() == -1) {
                            isComputerAlreadyMove = true;
                            trio[i].fire();
                        }
                    }
                }
            }
        }

        if (!isComputerAlreadyMove && numberOfMove < (sizeOfGame * sizeOfGame - 1) && board.getSceneChanger().getPlayerCreator().getComputerPlayer() != null) {
            while (!isComputerAlreadyMove) {
                int a = random.nextInt(sizeOfGame);
                int b = random.nextInt(sizeOfGame);
                if (board.getBoardButtons()[a][b].getValueOfButtonField() == -1) {
                    isComputerAlreadyMove = true;
                    board.getBoardButtons()[a][b].fire();
                    break;
                }
            }
        }
    }

    private void setY() {
        BackgroundImage backgroundCircle = new BackgroundImage(circle, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true));
        this.setBackground(new Background(backgroundCircle));
        valueOfButtonField = 1;
        board.whoWin();

    }

    public int getValueOfButtonField() {
        return valueOfButtonField;
    }

    public void setValueOfButtonField(int valueOfButtonField) {
        this.valueOfButtonField = valueOfButtonField;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public static void setNumberOfMove(int numberOfMove) {
        GameButton.numberOfMove = numberOfMove;
    }

    public Background getDefaultBackGroundButton() {
        return defaultBackGroundButton;
    }
}
