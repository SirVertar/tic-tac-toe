package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class NextGameButton extends Button {
    private SceneChanger sceneChanger;


    public NextGameButton(SceneChanger sceneChanger, int number) {
        Image nextGameButtonImage = new Image("file:resources/newgame.jpg");
        Background nextGameBackground = new Background(new BackgroundImage(nextGameButtonImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true)));
        this.sceneChanger = sceneChanger;
        this.setPrefSize(550, 150);
        this.setBackground(nextGameBackground);
        makeAnotherOption();
    }


    private void makeAnotherOption() {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            for (int i = 0; i < sceneChanger.getSizeOfGame(); i++) {
                for (int j = 0; j < sceneChanger.getSizeOfGame(); j++) {
                    sceneChanger.getBoard().getBoardButtons()[i][j].setBackground((
                            sceneChanger.getBoard().getBoardButtons()[1][1].getDefaultBackGroundButton()));
                    sceneChanger.getBoard().getBoardButtons()[i][j].setEmpty(true);
                    sceneChanger.getBoard().getBoardButtons()[i][j].setValueOfButtonField(-1);
                }
            }
            GameButton.setNumberOfMove(0);
            sceneChanger.getMainPane().getChildren().remove(sceneChanger.getWinningLabel());
        });
    }
}

