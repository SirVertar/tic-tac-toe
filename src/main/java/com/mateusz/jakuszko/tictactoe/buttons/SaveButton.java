package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.Player;
import com.mateusz.jakuszko.tictactoe.PlayerCreator;
import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveButton extends Button {
    private List<Player> listOfPlayers;
    private PlayerCreator playerCreator;
    private static File playerFile = new File("PlayerFile");
    private static File sceneChangerFile = new File("SceneChangerFile");
    private SceneChanger sceneChanger;


    public SaveButton (PlayerCreator playerCreator, SceneChanger sceneChanger) {
        Image saveButtonImage = new Image("file:resources/save.jpg");
        Background saveBackground = new Background(new BackgroundImage(saveButtonImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true)));
        this.playerCreator = playerCreator;
        this.listOfPlayers = playerCreator.getListOfPlayers();
        this.sceneChanger = sceneChanger;
        this.setPrefSize(100,100);
        this.setBackground(saveBackground);
        madeActionOnButton();

    }

    private void madeActionOnButton() {
        this.setOnAction(event -> {
            try (FileOutputStream fileOutputStreamPlayer = new FileOutputStream(playerFile);
                 FileOutputStream fileOutputStreamScene = new FileOutputStream(sceneChangerFile);
                 ObjectOutputStream objectOutputStreamPlayer = new ObjectOutputStream(fileOutputStreamPlayer);
                 ObjectOutputStream objectOutputStreamScene = new ObjectOutputStream(fileOutputStreamScene))
            {
                playerCreator.setListOfPlayers(new ArrayList<Player>());

                playerCreator.generateListOfPlayers();

                objectOutputStreamPlayer.writeObject(listOfPlayers);
                objectOutputStreamScene.writeObject(sceneChanger.getSizeOfGame());



            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("SAVE BUTTON");
        });
    }

    static void deleteFile(File file) {
        if(file.delete()) {
            System.out.println(file + "deleted sucessfully...");
        } else {
            System.out.println((file + " deletion failed!"));
        }
    }

    public static File getPlayerFile() {
        return playerFile;
    }

    public static File getSceneChangerFile() {
        return sceneChangerFile;
    }

}
