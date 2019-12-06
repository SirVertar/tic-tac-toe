package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.Board;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.Random;

public class GameButton extends Button {

    private Image circle = new Image("file:resources/circle.jpg");
    private Image xImage = new Image("file:resources/x.png");
    private boolean isEmpty = true;
    private static int numberOfMove = 0;
    private int valueOfButtonField = -1;
    private Board board;
    private Background defaultBackGroundButton = this.getBackground();
    private boolean is1PlayerHasAlreadyMoved = false;
    private boolean isComputerAlreadyMove = false;


    public GameButton(Board board) {
        this.board = board;
        this.setPrefSize(150, 150);
        this.setBlendMode(BlendMode.SOFT_LIGHT);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (numberOfMove % 2 == 0 && isEmpty) {
                    numberOfMove++;
                    isEmpty = false;
                    setX();
                } else if (numberOfMove % 2 != 0 && isEmpty) {
                    numberOfMove++;
                    isEmpty = false;
                    setY();
                }
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
        is1PlayerHasAlreadyMoved = true;
        isComputerAlreadyMove = false;
        int numberOfX = 0;
        int numberOfO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getBoardButtons()[i][j].getValueOfButtonField() == 0) {
                    numberOfX++;
                } else if (board.getBoardButtons()[i][j].getValueOfButtonField() == 1) {
                    numberOfO++;
                }
            }
        }
        Random random = new Random();
        if(board.getSceneChanger().getPlayerCreator().getComputerPlayer() != null && is1PlayerHasAlreadyMoved && numberOfMove<8) {
            for (GameButton[] trio : board.getWinningTrios()) {
                int counterX = 0;
                int counterO = 0;
                for (int i = 0; i < 3; i++) {
                    if (trio[i].getValueOfButtonField() == 0) {
                        counterX++;
                    } else if (trio[i].getValueOfButtonField() == 1) {
                        counterO++;
                    }
                }
                if (counterX == 2 && !isComputerAlreadyMove) {
                    for (int i = 0; i < 3; i++) {
                        if (trio[i].getValueOfButtonField() == -1) {
                            isComputerAlreadyMove = true;
                            trio[i].fire();
                            break;
                        }
                    }
                }
            }
        }
        if (!isComputerAlreadyMove && numberOfMove<8 && board.getSceneChanger().getPlayerCreator().getComputerPlayer() != null) {
            int a = random.nextInt(3);
            int b = random.nextInt(3);
            while (!isComputerAlreadyMove) {
                if(board.getBoardButtons()[a][b].getValueOfButtonField() == -1) {
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
