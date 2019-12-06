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
    private Image playerVsPlayerImage = new Image("file:resources/PvP.jpg");

    public MenuTwoPlayersButton(SceneChanger sceneChanger) {

        this.sceneChanger = sceneChanger;
        this.setPrefSize(550,150);
        makeActionOnButton();

        BackgroundSize backgroundSizePvp = new BackgroundSize(550, 540, true, true, true, false);
        BackgroundImage backgroundImagePvp = new BackgroundImage(playerVsPlayerImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, backgroundSizePvp);
        this.setBackground(new Background(backgroundImagePvp));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setTranslateX(0);
        this.setTranslateY(0);
        this.setTextAlignment(TextAlignment.RIGHT);
    }

    private void makeActionOnButton() {
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneChanger.getMainPane().getChildren().remove(0,4);
                sceneChanger.create2PlayersNameScene();
                sceneChanger.getPlayerCreator().createTwoHumanPlayers();
            }
        });
    }
}
