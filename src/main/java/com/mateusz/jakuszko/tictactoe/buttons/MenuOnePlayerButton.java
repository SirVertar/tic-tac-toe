package com.mateusz.jakuszko.tictactoe.buttons;

import com.mateusz.jakuszko.tictactoe.PlayerCreator;
import com.mateusz.jakuszko.tictactoe.SceneChanger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;


public class MenuOnePlayerButton extends Button {


    private SceneChanger sceneChanger;
    private Image playerVsComputerImage = new Image("file:resources/PvC.jpg");

    public MenuOnePlayerButton(SceneChanger sceneChanger) {

        this.sceneChanger = sceneChanger;
        this.setPrefSize(550, 150);
        makeAnotherOption();

        BackgroundImage backgroundCircle = new BackgroundImage(playerVsComputerImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(550, 150, false,
                        false, true, true));
        this.setBackground(new Background(backgroundCircle));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setTranslateX(0);
        this.setTranslateY(0);
        this.setTextAlignment(TextAlignment.RIGHT);
    }

    private void makeAnotherOption() {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sceneChanger.getMainPane().getChildren().remove(0, 4);
                sceneChanger.create1PlayersNameScene();
                sceneChanger.getPlayerCreator().createOnePlayerAndComputer(sceneChanger.getBoard());
            }
        });
    }


}
