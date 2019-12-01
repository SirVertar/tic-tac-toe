package com.mateusz.jakuszko.tictactoe.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExitButton extends Button {
    private Stage stage;

    public ExitButton (Pane root, Stage stage) {
        this.stage = stage;
        this.setPrefSize(450,150);
        this.setBlendMode(BlendMode.SOFT_LIGHT);
        madeActionOnButton();
    }

    public void madeActionOnButton() {
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello Worlds");
                stage.close();
            }
        });
    }
}
