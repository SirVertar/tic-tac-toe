package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;

public class EnterGameButton extends Button {


    private SceneChanger sceneChanger;

    public EnterGameButton(SceneChanger sceneChanger) {
        this.sceneChanger = sceneChanger;
        this.setPrefSize(450, 150);
        this.setBlendMode(BlendMode.SOFT_LIGHT);
        this.setText("Enter the game");
        makeActionOnButton();
    }

    private void makeActionOnButton() {
        this.setOnAction(event -> {
            int numberOfChild = 0;
            for (Node child : sceneChanger.getMainPane().getChildren()) {
                numberOfChild++;
            }
            if (numberOfChild == 3) {
                sceneChanger.getMainPane().getChildren().remove(0, 3);
                sceneChanger.setNameOfTwoPlayers();
            } else {
                sceneChanger.getMainPane().getChildren().remove(0, 2);
                sceneChanger.setNameOfOnePlayer();
            }
            sceneChanger.gameScene();
        });
    }
}
