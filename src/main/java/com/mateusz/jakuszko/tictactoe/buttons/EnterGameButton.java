package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;

public class EnterGameButton extends Button {


    private SceneChanger sceneChanger;

    public EnterGameButton(SceneChanger sceneChanger) {
        this.sceneChanger = sceneChanger;
        this.setPrefSize(450, 150);
        this.setBlendMode(BlendMode.SOFT_LIGHT);
        this.setText("Enter the game");
        makeActionOnButton();
    }

    public void makeActionOnButton() {
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
            }
        });
    }
}
