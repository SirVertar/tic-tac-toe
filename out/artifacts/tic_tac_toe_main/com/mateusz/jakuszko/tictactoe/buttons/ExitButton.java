package com.mateusz.jakuszko.tictactoe.buttons;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExitButton extends Button {
    private Stage stage;

    public ExitButton (Stage stage) {
        this.stage = stage;
        this.setPrefSize(550,150);
        madeActionOnButton();
    }

    private void madeActionOnButton() {
        this.setOnAction(event -> {
            stage.close();
        });
    }
}
