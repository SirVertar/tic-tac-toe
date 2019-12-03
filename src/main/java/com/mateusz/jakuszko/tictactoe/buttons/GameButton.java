package com.mateusz.jakuszko.tictactoe.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class GameButton extends Button {

    private Image circle = new Image("file:resources/circle.jpg");
    private Image xImage = new Image("file:resources/x.png");
    private boolean isEmpty = true;
    private static int numberOfMove = 0;

    public GameButton() {
        this.setPrefSize(150, 150);
        this.setBlendMode(BlendMode.SOFT_LIGHT);

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (numberOfMove % 2 == 0 && isEmpty) {
                    setX();
                    numberOfMove++;
                    isEmpty = false;
                } else if (numberOfMove % 2 != 0 && isEmpty) {
                    setY();
                    numberOfMove++;
                    isEmpty = false;
                }
            }
        });
    }

    private void setX() {
        BackgroundImage backgroundCircle = new BackgroundImage(circle, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true));
        this.setBackground(new Background(backgroundCircle));
        this.setId("circle");
    }

    private void setY() {
        BackgroundImage backgroundCircle = new BackgroundImage(xImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true));
        this.setBackground(new Background(backgroundCircle));
        this.setId("cross");
    }
}
