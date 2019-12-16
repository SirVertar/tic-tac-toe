package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class RestartButton extends Button {

    private SceneChanger sceneChanger;

    public RestartButton(SceneChanger sceneChanger, int number) {
        Image restartButtonImage = new Image("file:resources/restart.jpg");
        Background restartBackground = new Background(new BackgroundImage(restartButtonImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true)));
        this.sceneChanger = sceneChanger;
        this.setPrefSize(550, 150);
        this.setBackground(restartBackground);
        restartGame();
    }

    private void restartGame() {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            for (int i = 0; i < sceneChanger.getSizeOfGame(); i++) {
                for (int j = 0; j < sceneChanger.getSizeOfGame(); j++) {
                    sceneChanger.getBoard().getBoardButtons()[i][j].setBackground((sceneChanger.getBoard().getBoardButtons()[i][j].getDefaultBackGroundButton()));
                    sceneChanger.getBoard().getBoardButtons()[i][j].setEmpty(true);
                    sceneChanger.getBoard().getBoardButtons()[i][j].setValueOfButtonField(-1);
                    sceneChanger.getPlayerCreator().getHumanPlayer1().setScore(0);
                    sceneChanger.getMainPane().setBackground(sceneChanger.getMainBackground());
                    if (sceneChanger.getPlayerCreator().getHumanPlayer2() != null) {
                        sceneChanger.getPlayerCreator().getHumanPlayer2().setScore(0);
                    } else {
                        sceneChanger.getPlayerCreator().getComputerPlayer().setScore(0);
                    }
                    sceneChanger.getBoard().changePlayersScoreLabels();
                    GameButton.setNumberOfMove(0);
                    sceneChanger.getMainPane().getChildren().remove(sceneChanger.getWinningLabel());
                    sceneChanger.getMainPane().setBackground(sceneChanger.getMainBackground());
                }
            }
        });
    }
}
