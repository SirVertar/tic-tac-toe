package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;


public class MenuOnePlayerButton extends Button {

    private SceneChanger sceneChanger;

    public MenuOnePlayerButton(SceneChanger sceneChanger) {

        this.sceneChanger = sceneChanger;
        this.setPrefSize(550, 100);
        makeAnotherOption();

        Image playerVsComputerImage = new Image("file:resources/pvc.jpg");
        BackgroundImage backgroundCircle = new BackgroundImage(playerVsComputerImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(550, 150, true,
                        true, true, false));
        this.setBackground(new Background(backgroundCircle));
        this.setTranslateX(0);
        this.setTranslateY(0);
        this.setTextAlignment(TextAlignment.RIGHT);
    }

    private void makeAnotherOption() {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            sceneChanger.getMainPane().getChildren().remove(0, 5);
            sceneChanger.create1PlayersNameScene();
            sceneChanger.getPlayerCreator().createOnePlayerAndComputer(sceneChanger.getBoard());
        });
    }


}
