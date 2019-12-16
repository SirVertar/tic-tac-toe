package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import static com.mateusz.jakuszko.tictactoe.buttons.GameButton.numberOfMove;

public class MenuBackButton extends Button {

    private SceneChanger sceneChanger;

    public MenuBackButton(SceneChanger sceneChanger) {
        this.sceneChanger = sceneChanger;
        this.setPrefSize(100, 50);
        Image menuButtonImage = new Image("file:resources/menu.jpg");
        Background menuButtonBackground = new Background(new BackgroundImage(menuButtonImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true)));
        this.setBackground(menuButtonBackground);
        returnToMenu();
    }

    private void returnToMenu() {
        this.setOnAction(event -> {
            int numberOfChild = 0;

            for (Node child : sceneChanger.getMainPane().getChildren()) {
                numberOfChild++;
            }
            sceneChanger.getMainPane().getChildren().remove(0, numberOfChild);
            sceneChanger.menuScene();
            numberOfMove = 0;
            sceneChanger.getPlayerCreator().setHumanPlayer2(null);
            sceneChanger.getPlayerCreator().setHumanPlayer1(null);
            sceneChanger.getPlayerCreator().setComputerPlayer(null);
        });
    }
}
