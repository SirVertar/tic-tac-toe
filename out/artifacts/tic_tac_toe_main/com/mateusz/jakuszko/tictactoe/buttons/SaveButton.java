package com.mateusz.jakuszko.tictactoe.buttons;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SaveButton extends Button {
    private Stage stage;

    public SaveButton (Stage stage) {
        this.stage = stage;
        this.setPrefSize(550,150);
        madeActionOnButton();
        this.setText("SAVE");
    }

    private void madeActionOnButton() {
        this.setOnAction(event -> {
            stage.close();
        });
    }
}
