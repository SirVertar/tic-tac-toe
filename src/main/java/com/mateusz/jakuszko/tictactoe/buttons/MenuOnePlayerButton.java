package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.PlayerCreator;
import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class MenuOnePlayerButton extends Button {

    private Pane mainPane;
    private PlayerCreator playerCreator;

    public MenuOnePlayerButton(Pane mainPane, PlayerCreator playerCreator) {
        this.mainPane = mainPane;
        this.playerCreator = playerCreator;
        this.setPrefSize(450,150);
        this.setBlendMode(BlendMode.SOFT_LIGHT);
        this.setId("1PlayerButton");
        makeAnotherOption();
    }

    public void makeActionOnButton() {
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                setText("accepted");
                mainPane.getChildren().remove(0,4);
                SceneChanger sceneChanger = new SceneChanger();
                sceneChanger.create1PlayersNameScene(mainPane);
            }
        });
    }

    public void makeAnotherOption() {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainPane.getChildren().remove(0,4);
                SceneChanger sceneChanger = new SceneChanger();
                sceneChanger.create1PlayersNameScene(mainPane);
                playerCreator.createOnePlayerAndComputer("jeden wiesniak");
            }
        });
    }


}
