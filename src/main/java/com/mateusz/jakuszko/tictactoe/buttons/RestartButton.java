package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.PlayerCreator;
import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class RestartButton extends Button {

    private SceneChanger sceneChanger;

    public RestartButton(SceneChanger sceneChanger) {

        this.sceneChanger = sceneChanger;
        this.setPrefSize(550, 150);
        this.setBlendMode(BlendMode.SOFT_LIGHT);
        makeAnotherOption();
    }


    public void makeAnotherOption() {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        sceneChanger.getBoard().getBoardButtons()[i][j].setBackground(( sceneChanger.getBoard().getBoardButtons()[i][j].getDefaultBackGroundButton()));
                        sceneChanger.getBoard().getBoardButtons()[i][j].setEmpty(true);
                        sceneChanger.getBoard().getBoardButtons()[i][j].setValueOfButtonField(-1);
                        sceneChanger.getPlayerCreator().getHumanPlayer1().setScore(0);
                        if (sceneChanger.getPlayerCreator().getHumanPlayer2() != null) {
                            sceneChanger.getPlayerCreator().getHumanPlayer2().setScore(0);
                        } else {
                            sceneChanger.getPlayerCreator().getComputerPlayer().setScore(0);
                        }
                        sceneChanger.getBoard().changePlayersScoreLabels();
                        sceneChanger.getMainPane().setBackground(sceneChanger.getDefaultBackground());
                        GameButton.setNumberOfMove(0);

                    }
                }
            }
        });
    }
}
