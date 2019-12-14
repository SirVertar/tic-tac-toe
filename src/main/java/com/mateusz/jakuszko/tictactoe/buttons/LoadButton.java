package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.HumanPlayer;
import com.mateusz.jakuszko.tictactoe.Player;
import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class LoadButton extends Button {

    SceneChanger sceneChanger;
    private String fileName = "playersObjects";
    private List<Player> listOfPlayers;

    public LoadButton (SceneChanger sceneChanger) {
        this.sceneChanger = sceneChanger;
        this.setPrefSize(550, 100);
        madeActionOnButton();

        Image playerVsComputerImage = new Image("file:resources/PvC.jpg");
        BackgroundImage backgroundCircle = new BackgroundImage(playerVsComputerImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(550, 150, false,
                        false, true, true));
        this.setBackground(new Background(backgroundCircle));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setTranslateX(0);
        this.setTranslateY(0);
        this.setTextAlignment(TextAlignment.RIGHT);
        this.setText("LOAD");
    }

    private void madeActionOnButton() {
        this.setOnAction(event -> {
            try {
                FileInputStream fileInputStream = new FileInputStream(SaveButton.getFile());
                System.out.println(1);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                System.out.println(2);
                listOfPlayers = (List<Player>) objectInputStream.readObject();
                System.out.println(3);
                sceneChanger.getPlayerCreator().setHumanPlayer1((HumanPlayer) listOfPlayers.get(0));
                System.out.println(sceneChanger.getPlayerCreator().getHumanPlayer1());
                sceneChanger.getPlayerCreator().setHumanPlayer2((HumanPlayer) listOfPlayers.get(1));
                System.out.println(5);
                System.out.println(sceneChanger.getPlayerCreator().getHumanPlayer2());
                sceneChanger.gameSceneByLoadFile();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
