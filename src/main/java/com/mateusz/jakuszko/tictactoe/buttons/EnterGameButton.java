package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class EnterGameButton extends Button {

    private SceneChanger sceneChanger;

    public EnterGameButton(SceneChanger sceneChanger) {
        this.sceneChanger = sceneChanger;
        this.setPrefSize(450, 150);
        makeActionOnButton();
    }

    private void makeActionOnButton() {
        this.setOnAction(event -> {
            int numberOfChild = 0;
            for (Node child : sceneChanger.getMainPane().getChildren()) {
                numberOfChild++;
            }
            if (numberOfChild == 5) {
                sceneChanger.getMainPane().getChildren().remove(0, 5);
                sceneChanger.setNameOfTwoPlayers();
                sceneChanger.setNumberOfRowsAndColumns();
            } else {
                sceneChanger.getMainPane().getChildren().remove(0, 4);
                sceneChanger.setNameOfOnePlayer();
                sceneChanger.setNumberOfRowsAndColumns();
            }
            sceneChanger.gameScene();
        });
    }
}
