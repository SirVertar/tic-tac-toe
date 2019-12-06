package com.mateusz.jakuszko.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class TicTacToeMain extends Application {

    private Image backGroundImage = new Image("file:resources/background.png");


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("TIC-TAC-TOE");
        FlowPane pane = new FlowPane();

        BackgroundSize backgroundSize = new BackgroundSize(550, 540, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(backGroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        pane.setBackground(background);

        pane.setPrefSize(550, 540);
        Scene scene = new Scene(pane, 550, 540, Color.DARKGREY);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        SceneChanger sceneChanger = new SceneChanger(pane, primaryStage);
        sceneChanger.menuScene();

    }
}
