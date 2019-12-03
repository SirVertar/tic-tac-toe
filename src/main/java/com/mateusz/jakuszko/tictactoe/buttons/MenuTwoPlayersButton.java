package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.PlayerCreator;
import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;

public class MenuTwoPlayersButton extends Button {

    private Pane mainPane;
    private PlayerCreator playerCreator;

    public MenuTwoPlayersButton(Pane mainPane, PlayerCreator playerCreator) {
        this.mainPane = mainPane;
        this.playerCreator = playerCreator;
        this.setPrefSize(450,150);
        this.setBlendMode(BlendMode.SOFT_LIGHT);
        this.setId("2PlayerButton");
        makeActionOnButton();
    }

    public void makeActionOnButton() {
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainPane.getChildren().remove(0,4);
                SceneChanger sceneChanger = new SceneChanger();
                sceneChanger.create2PlayersNameScene(mainPane);
                playerCreator.createTwoHumanPlayers("mama", "tata");
            }
        });
    }
}
