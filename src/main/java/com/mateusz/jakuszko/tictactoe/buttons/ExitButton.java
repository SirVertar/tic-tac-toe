package com.mateusz.jakuszko.tictactoe.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExitButton extends Button {
    private Stage stage;

    public ExitButton (Stage stage) {
        this.stage = stage;
        this.setPrefSize(550,150);
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
