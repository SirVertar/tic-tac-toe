package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.PlayerCreator;
import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class MenuTwoPlayersButton extends Button {

    private SceneChanger sceneChanger;

    public MenuTwoPlayersButton(SceneChanger sceneChanger) {

        this.sceneChanger = sceneChanger;
        this.setPrefSize(550, 100);
        makeActionOnButton();

        BackgroundSize backgroundSizePvp = new BackgroundSize(550, 540, true, true, true, false);
        Image playerVsPlayerImage = new Image("file:resources/pvp.jpg");
        BackgroundImage backgroundImagePvp = new BackgroundImage(playerVsPlayerImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, backgroundSizePvp);
        this.setBackground(new Background(backgroundImagePvp));
        this.setTranslateX(0);
        this.setTranslateY(0);
        this.setTextAlignment(TextAlignment.RIGHT);
    }

    private void makeActionOnButton() {
        this.setOnAction(event -> {
            sceneChanger.getMainPane().getChildren().remove(0, 5);
            sceneChanger.create2PlayersNameScene();
            sceneChanger.getPlayerCreator().createTwoHumanPlayers();
        });
    }
}
