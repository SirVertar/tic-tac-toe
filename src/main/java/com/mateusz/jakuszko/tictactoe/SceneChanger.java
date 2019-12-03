package com.mateusz.jakuszko.tictactoe;

import com.mateusz.jakuszko.tictactoe.buttons.*;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SceneChanger {

    private Image xImage = new Image("file:resources/x.png");
    private GameButton[][] listOfGameButtons = new GameButton[3][3];
    private static PlayerCreator playerCreator = new PlayerCreator();
    private TextField textField1;
    private TextField textField2;

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

        MenuTwoPlayersButton menuTwoPlayerButton = new MenuTwoPlayersButton(mainPain, playerCreator);
        menuTwoPlayerButton.setTranslateX(0);
        menuTwoPlayerButton.setTranslateY(0);
        menuTwoPlayerButton.setText("PLAYER VS PLAYER");
        menuTwoPlayerButton.setTextAlignment(TextAlignment.RIGHT);



        MenuOnePlayerButton menuOnePlayerButton = new MenuOnePlayerButton(mainPain, playerCreator);
        menuOnePlayerButton.setTranslateX(0);
        menuOnePlayerButton.setTranslateY(0);
        menuOnePlayerButton.setText("PLAYER VS COMPUTER");
        menuOnePlayerButton.setTextAlignment(TextAlignment.RIGHT);


        ExitButton menuButton3 = new ExitButton(mainPain, stage);
        menuButton3.setTranslateX(0);
        menuButton3.setTranslateY(0);
        menuButton3.setText("EXIT GAME");
        menuButton3.setTextAlignment(TextAlignment.RIGHT);

        mainPain.getChildren().add(menuTwoPlayerButton);
        mainPain.getChildren().add(menuOnePlayerButton);
        mainPain.getChildren().add(menuButton3);


    }

    public void gameScene(Pane mainPane) {

        mainPane.setPrefSize(450, 600);
        HBox hBox = new HBox();
        hBox.setPrefSize(450, 90);
        mainPane.getChildren().add(hBox);

        Label player1Label = new Label(playerCreator.getHumanPlayer1().getName());
        player1Label.setPrefSize(150,90);
        player1Label.setPadding(new Insets(10));
        player1Label.setAlignment(Pos.CENTER);
        player1Label.setMaxWidth(150);
        player1Label.setTextFill(Color.GREEN);
        player1Label.setFont(Font.font(30));
        player1Label.setTextAlignment(TextAlignment.CENTER);


        Label player2Label = new Label();
        player2Label.setPrefSize(200,90);
        player2Label.setTranslateX(150);
        player2Label.setPadding(new Insets(10));
        player2Label.setAlignment(Pos.CENTER);
        player2Label.setMaxWidth(150);
        player2Label.setTextFill(Color.GREEN);
        player2Label.setFont(Font.font(30));
        player2Label.setTextAlignment(TextAlignment.CENTER);

        if(playerCreator.getHumanPlayer2() != null) {
            player2Label.setText(playerCreator.getHumanPlayer2().getName());
        } else {
            player2Label.setText(playerCreator.getComputerPlayer().getName());
        }

        hBox.getChildren().add(player1Label);
        hBox.getChildren().add(player2Label);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GameButton button = new GameButton();
                button.setId("" + i + j);
                button.setText("" + i + j);
                listOfGameButtons[i][j] = button;
                mainPane.getChildren().add(button);
            }
        }
    }

    public void create1PlayersNameScene(Pane mainPane) {

        HBox hBox1 = new HBox();
        hBox1.setPrefSize(450, 90);
        hBox1.setTranslateY(100);
        mainPane.getChildren().add(hBox1);
        Label label = new Label("Enter your name");
        label.setPrefSize(200, 80);
        TextField textField1 = new TextField();
        textField1.setPromptText("Enter your name");
        textField1.setPrefSize(200, 80);
        hBox1.getChildren().addAll(label, textField1);

        this.textField1 = textField1;


        EnterGameButton button = new EnterGameButton(mainPane, this);
        button.setTranslateX(200);
        button.setTranslateY(300);
        button.setPrefSize(200, 80);
        mainPane.getChildren().add(button);
    }

    public void setNameOfOnePlayer() {
        playerCreator.getHumanPlayer1().setName(textField1.getText());
        System.out.println(playerCreator.getHumanPlayer1().getName());
    }

    public void create2PlayersNameScene(Pane mainPane) {

        create1PlayersNameScene(mainPane);

        HBox hBox2 = new HBox();
        hBox2.setPrefSize(450, 90);
        hBox2.setTranslateY(50);
        mainPane.getChildren().add(hBox2);
        Label label1 = new Label("Enter your name");
        label1.setPrefSize(200, 90);
        TextField textField2 = new TextField();
        textField2.setPromptText("Enter your name");
        textField2.setPrefSize(200, 90);
        hBox2.getChildren().addAll(label1, textField2);

        this.textField2 = textField2;
    }

    public void setNameOfTwoPlayers() {
        setNameOfOnePlayer();
        playerCreator.getHumanPlayer2().setName(textField2.getText());
        System.out.println(playerCreator.getHumanPlayer2().getName());
    }




    public GameButton[][] getListOfGameButtons() {
        return listOfGameButtons;
    }

}


