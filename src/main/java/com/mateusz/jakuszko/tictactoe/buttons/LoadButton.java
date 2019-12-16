package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.ComputerPlayer;
import com.mateusz.jakuszko.tictactoe.HumanPlayer;
import com.mateusz.jakuszko.tictactoe.Player;
import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class LoadButton extends Button {

    private SceneChanger sceneChanger;
    private List<Player> listOfPlayers;
    private Integer sizeOfGame;

    public LoadButton (SceneChanger sceneChanger) {
        this.sceneChanger = sceneChanger;
        this.setPrefSize(550, 100);
        madeActionOnButton();

        Image playerVsComputerImage = new Image("file:resources/llg.jpg");
        BackgroundImage backgroundCircle = new BackgroundImage(playerVsComputerImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(550, 150, true,
                        true, true, false));
        this.setBackground(new Background(backgroundCircle));
        this.setTranslateX(0);
        this.setTranslateY(0);
        this.setTextAlignment(TextAlignment.RIGHT);
    }

    private void madeActionOnButton() {
        this.setOnAction(event -> {
            try (FileInputStream playerFileInputStream = new FileInputStream(SaveButton.getPlayerFile());
                FileInputStream sceneChangerFileInputStream = new FileInputStream(SaveButton.getSceneChangerFile());
                ObjectInputStream playerObjectInputStream = new ObjectInputStream(playerFileInputStream);
                ObjectInputStream sceneChangerObjectInputStream = new ObjectInputStream(sceneChangerFileInputStream))
            {
                listOfPlayers = (List<Player>)playerObjectInputStream.readObject();
                sizeOfGame = (Integer)sceneChangerObjectInputStream.readObject();
                sceneChanger.getPlayerCreator().setHumanPlayer1((HumanPlayer) listOfPlayers.get(0));
                if(listOfPlayers.get(1).getId() == 1) {
                    sceneChanger.getPlayerCreator().setHumanPlayer2((HumanPlayer) listOfPlayers.get(1));
                    sceneChanger.getPlayerCreator().setComputerPlayer(null);
                } else {
                    sceneChanger.getPlayerCreator().setComputerPlayer((ComputerPlayer)listOfPlayers.get(1));
                    sceneChanger.getPlayerCreator().setHumanPlayer2(null);
                }
                sceneChanger.setSizeOfGame(sizeOfGame);
                sceneChanger.gameSceneByLoadFile();
                sceneChanger.setMainPaneBackground();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

}
