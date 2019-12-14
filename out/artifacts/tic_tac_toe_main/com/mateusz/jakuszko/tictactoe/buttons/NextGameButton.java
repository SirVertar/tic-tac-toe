package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseEvent;

public class NextGameButton extends Button {
    private SceneChanger sceneChanger;

    public NextGameButton(SceneChanger sceneChanger) {
        this.sceneChanger = sceneChanger;
        this.setPrefSize(550, 150);
        this.setBlendMode(BlendMode.SOFT_LIGHT);
        this.setText("NEXT GAME");
        makeAnotherOption();
    }


    private void makeAnotherOption() {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sceneChanger.getBoard().getBoardButtons()[i][j].setBackground((
                            sceneChanger.getBoard().getBoardButtons()[1][1].getDefaultBackGroundButton()));
                    sceneChanger.getBoard().getBoardButtons()[i][j].setEmpty(true);
                    sceneChanger.getBoard().getBoardButtons()[i][j].setValueOfButtonField(-1);
                }
            }
            sceneChanger.getMainPane().setBackground(sceneChanger.getDefaultBackground());
            GameButton.setNumberOfMove(0);
        });
    }
}

