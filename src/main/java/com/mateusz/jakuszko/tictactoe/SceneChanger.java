package com.mateusz.jakuszko.tictactoe;

import com.mateusz.jakuszko.tictactoe.buttons.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SceneChanger {

    private Image xImage = new Image("file:resources/x.png");

    public void menuScene(Pane mainPain, Stage stage) {
        Pane nameOFTheGame = new Pane();
        BackgroundSize backgroundSize = new BackgroundSize(450, 540, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(xImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, backgroundSize);
        nameOFTheGame.setBackground(new Background(backgroundImage));
        nameOFTheGame.setPrefSize(450, 90);
        nameOFTheGame.setTranslateX(0);
        nameOFTheGame.setTranslateY(0);
        mainPain.getChildren().add(nameOFTheGame);

        MenuTwoPlayersButton menuOnePlayerButton = new MenuTwoPlayersButton(mainPain);
        menuOnePlayerButton.setTranslateX(0);
        menuOnePlayerButton.setTranslateY(0);
        menuOnePlayerButton.setText("PLAYER VS PLAYER");
        menuOnePlayerButton.setTextAlignment(TextAlignment.RIGHT);

        MenuOnePlayerButton menuOnePlayerButton2 = new MenuOnePlayerButton(mainPain);
        menuOnePlayerButton2.setTranslateX(0);
        menuOnePlayerButton2.setTranslateY(0);
        menuOnePlayerButton2.setText("PLAYER VS COMPUTER");
        menuOnePlayerButton2.setTextAlignment(TextAlignment.RIGHT);

        ExitButton menuButton3 = new ExitButton(mainPain, stage);
        menuButton3.setTranslateX(0);
        menuButton3.setTranslateY(0);
        menuButton3.setText("EXIT GAME");
        menuButton3.setTextAlignment(TextAlignment.RIGHT);

        mainPain.getChildren().add(menuOnePlayerButton);
        mainPain.getChildren().add(menuOnePlayerButton2);
        mainPain.getChildren().add(menuButton3);
    }

    public void setGameScene(Pane mainPane) {
        mainPane.setPrefSize(750, 750);
        Pane scorePanel = new Pane();
        scorePanel.setPrefSize(750, 90);
        mainPane.getChildren().add(scorePanel);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GameButton button = new GameButton();
                button.setId("" + i + j);
                button.setText("" + i + j);
                mainPane.getChildren().add(button);
            }
        }
    }

    public void setCreate1PlayersNameScene(Pane mainPane) {

        HBox hBox1 = new HBox();
        hBox1.setPrefSize(450, 90);
        hBox1.setTranslateY(100);
        mainPane.getChildren().add(hBox1);
        Label label = new Label("Enter your name");
        label.setPrefSize(200, 80);
        TextField textField = new TextField();
        textField.setPromptText("Enter your name");
        textField.setPrefSize(200, 80);
        hBox1.getChildren().addAll(label, textField);

        EnterGameButton button = new EnterGameButton(mainPane);
        button.setTranslateX(200);
        button.setTranslateY(300);
        button.setPrefSize(200, 80);
        mainPane.getChildren().add(button);

    }

    public void setCreate2PlayersNameScene(Pane mainPane) {

        setCreate1PlayersNameScene(mainPane);

        HBox hBox2 = new HBox();
        hBox2.setPrefSize(450, 90);
        hBox2.setTranslateY(50);
        mainPane.getChildren().add(hBox2);
        Label label1 = new Label("Enter your name");
        label1.setPrefSize(200, 90);
        TextField textField1 = new TextField();
        textField1.setPromptText("Enter your name");
        textField1.setPrefSize(200, 90);
        hBox2.getChildren().addAll(label1, textField1);

    }


}
