package com.mateusz.jakuszko.tictactoe.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ExitButton extends Button {

    private Stage stage;

    public ExitButton (Stage stage) {
        Image exitButtonImage = new Image("file:resources/exit.jpg");
        Background exitBackground = new Background(new BackgroundImage(exitButtonImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true)));
        this.stage = stage;
        this.setPrefSize(550,150);
        this.setBackground(exitBackground);
        madeActionOnButton();
    }

    private void madeActionOnButton() {
        this.setOnAction(event -> {
            stage.close();
        });
    }
}
