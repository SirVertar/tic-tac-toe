package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.Player;
import com.mateusz.jakuszko.tictactoe.PlayerCreator;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveButton extends Button {
    private List<Player> listOfPlayers;
    PlayerCreator playerCreator;
    private static File file = new File("FILE");


    public SaveButton (PlayerCreator playerCreator) {
        this.playerCreator = playerCreator;
        this.listOfPlayers = playerCreator.getListOfPlayers();
        this.setPrefSize(100,100);
        madeActionOnButton();
        this.setText("SAVE");
        this.setBlendMode(BlendMode.SOFT_LIGHT);
    }

    private void madeActionOnButton() {
        this.setOnAction(event -> {
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
            {
                if(listOfPlayers.isEmpty()) {
                    playerCreator.generateListOfPlayers();
                }
                objectOutputStream.writeObject(listOfPlayers);
                objectOutputStream.flush();
                objectOutputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static File getFile() {
        return file;
    }
}
