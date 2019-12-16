package com.mateusz.jakuszko.tictactoe;

import com.mateusz.jakuszko.tictactoe.buttons.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.regex.Pattern;

public class SceneChanger implements Serializable {

    private static final long serialVersionUID = -319430727918043057L;
    private Image gameNameImage = new Image("file:resources/ttc.jpg");
    private Image exitImage = new Image("file:resources/exit_game.jpg");

    private static PlayerCreator playerCreator = new PlayerCreator();
    private static Board board;
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private Pane mainPane;
    private Stage mainStage;
    private Label player1ScoreLabel;
    private Label player2ScoreLabel;
    private int sizeOfGame;
    private Background firstPlayerLabelBackground;
    private Background secondPlayerLabelBackground;
    private Background gameSizeLabelBackground;
    private Background startLabelBackground;
    private Background mainBackground;
    private Label winningLabel;
    private SaveButton saveButton;

    SceneChanger(Pane mainPane, Stage mainStage, int sizeOfGame) {
        Image firstPlayerImage = new Image("file:resources/firstPlayer.jpg");
        firstPlayerLabelBackground = new Background(new BackgroundImage(firstPlayerImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true)));
        Image secondPlayerImage = new Image("file:resources/secondplayer.jpg");
        secondPlayerLabelBackground = new Background(new BackgroundImage(secondPlayerImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true)));
        Image gameSizeImage = new Image("file:resources/gamesize.jpg");
        gameSizeLabelBackground = new Background(new BackgroundImage(gameSizeImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true)));
        Image startImage = new Image("file:resources/start.jpg");
        startLabelBackground = new Background(new BackgroundImage(startImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true)));
        Image backgroundImage = new Image("file:resources/background.jpg");
        mainBackground = new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 250, true,
                        true, true, true)));
        this.sizeOfGame = sizeOfGame;
        this.mainStage = mainStage;
        this.mainPane = mainPane;
        Background defaultBackground = mainPane.getBackground();
    }


    public void menuScene() {
        Pane nameOFTheGame = new Pane();
        BackgroundSize backgroundSize = new BackgroundSize(550, 540, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(gameNameImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, backgroundSize);
        nameOFTheGame.setBackground(new Background(backgroundImage));
        nameOFTheGame.setPrefSize(550, 90);
        nameOFTheGame.setTranslateX(0);
        nameOFTheGame.setTranslateY(0);
        mainPane.getChildren().add(nameOFTheGame);


        MenuTwoPlayersButton menuTwoPlayerButton = new MenuTwoPlayersButton(this);
        MenuOnePlayerButton menuOnePlayerButton = new MenuOnePlayerButton(this);
        LoadButton loadButton = new LoadButton(this);

        ExitButton menuButton3 = new ExitButton(mainStage);
        menuButton3.setTranslateX(0);
        menuButton3.setTranslateY(0);
        menuButton3.setTextAlignment(TextAlignment.RIGHT);
        BackgroundImage backgroundCircle = new BackgroundImage(exitImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(550, 150, false,
                        false, true, true));
        menuButton3.setBackground(new Background(backgroundCircle));

        mainPane.getChildren().add(menuTwoPlayerButton);
        mainPane.getChildren().add(menuOnePlayerButton);
        mainPane.getChildren().add(loadButton);
        mainPane.getChildren().add(menuButton3);
    }

    public void gameSceneByLoadFile() {
        this.getMainPane().getChildren().remove(0, 5);
        gameScene();
    }

    public void gameScene() {

        HBox hBox = new HBox();
        hBox.setPrefSize(450, 90);
        mainPane.getChildren().add(hBox);

        player1ScoreLabel = new Label(playerCreator.getHumanPlayer1().getName() + ": " + playerCreator.getHumanPlayer1().getScore());
        player1ScoreLabel.setPrefSize(225, 90);
        player1ScoreLabel.setPadding(new Insets(10));
        player1ScoreLabel.setAlignment(Pos.CENTER);
        player1ScoreLabel.setMaxWidth(225);
        player1ScoreLabel.setTextFill(Color.GREEN);
        player1ScoreLabel.setFont(Font.font(25));
        player1ScoreLabel.setTextAlignment(TextAlignment.CENTER);
        player1ScoreLabel.setBlendMode(BlendMode.OVERLAY);

        player2ScoreLabel = new Label();
        player2ScoreLabel.setPrefSize(225, 90);
        player2ScoreLabel.setTranslateX(0);
        player2ScoreLabel.setPadding(new Insets(10));
        player2ScoreLabel.setAlignment(Pos.CENTER);
        player2ScoreLabel.setMaxWidth(225);
        player2ScoreLabel.setTextFill(Color.GREEN);
        player2ScoreLabel.setFont(Font.font(25));
        player2ScoreLabel.setTextAlignment(TextAlignment.CENTER);
        player2ScoreLabel.setBlendMode(BlendMode.OVERLAY);

        if (playerCreator.getHumanPlayer2() != null) {
            player2ScoreLabel.setText(playerCreator.getHumanPlayer2().getName() + ": " + playerCreator.getHumanPlayer2().getScore());
        } else {
            player2ScoreLabel.setText(playerCreator.getComputerPlayer().getName() + ": " + playerCreator.getComputerPlayer().getScore());
        }

        RestartButton restartButton = new RestartButton(this, sizeOfGame);
        restartButton.setPrefSize(100, 100);
        restartButton.setTranslateY(100);
        mainPane.getChildren().add(restartButton);

        NextGameButton nextButton = new NextGameButton(this, sizeOfGame);
        nextButton.setPrefSize(100, 100);
        nextButton.setTranslateX(450);
        nextButton.setTranslateY(100);
        mainPane.getChildren().add(nextButton);

        saveButton = new SaveButton(playerCreator, this);
        saveButton.setTranslateX(350);
        saveButton.setTranslateY(200);
        mainPane.getChildren().add(saveButton);

        MenuBackButton menuBackButton = new MenuBackButton(this);
        menuBackButton.setTranslateX(250);
        menuBackButton.setTranslateY(275);
        mainPane.getChildren().add(menuBackButton);

        ExitButton exitButton = new ExitButton(mainStage);
        exitButton.setPrefSize(100, 100);
        exitButton.setTranslateX(150);
        exitButton.setTranslateY(350);
        mainPane.getChildren().add(exitButton);

        hBox.getChildren().add(player1ScoreLabel);
        hBox.getChildren().add(player2ScoreLabel);
        board = new Board(this);

        GridPane gridPane = new GridPane();
        gridPane.setTranslateY(-100);

        for (int i = 0; i < sizeOfGame; i++) {
            for (int j = 0; j < sizeOfGame; j++) {
                gridPane.add(board.getBoardButtons()[i][j], i, j);
            }
        }
        mainPane.getChildren().add(gridPane);

    }

    public void create1PlayersNameScene() {
        mainPane.setBackground(mainBackground);
        Pane nameOFTheGame = new Pane();
        BackgroundSize backgroundSize = new BackgroundSize(550, 540, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(gameNameImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, backgroundSize);
        nameOFTheGame.setBackground(new Background(backgroundImage));
        nameOFTheGame.setPrefSize(550, 90);
        nameOFTheGame.setTranslateX(0);
        nameOFTheGame.setTranslateY(0);
        mainPane.getChildren().add(nameOFTheGame);


        HBox hBox1 = new HBox();
        hBox1.setPrefSize(450, 100);
        hBox1.setTranslateY(10);
        hBox1.setTranslateX(10);
        mainPane.getChildren().add(hBox1);
        Label label1 = new Label();
        label1.setBackground(firstPlayerLabelBackground);
        label1.setPrefSize(200, 100);
        TextField textField1 = new TextField();
        textField1.setBackground(mainBackground);
        textField1.setPromptText("Enter your name");
        textField1.setStyle("-fx-prompt-text-fill: whitesmoke; -fx-alignment: center; -fx-font-size: 20px;" +
                " -fx-text-fill: whitesmoke; -fx-font-family: Georgia;");
        textField1.setPrefSize(200, 100);
        hBox1.getChildren().addAll(label1, textField1);

        HBox hBox3 = new HBox();
        hBox3.setPrefSize(450, 100);
        hBox3.setTranslateY(130);
        hBox3.setTranslateX(10);
        mainPane.getChildren().add(hBox3);
        Label label2 = new Label();
        label2.setBackground(gameSizeLabelBackground);
        label2.setPrefSize(200, 100);
        TextField textField3 = new TextField();
        textField3.setBackground(mainBackground);
        textField3.setPromptText("Enter size of Game");
        textField3.setStyle("-fx-prompt-text-fill: whitesmoke; -fx-alignment: center; -fx-font-size: 20px;" +
                " -fx-text-fill: whitesmoke; -fx-font-family: Georgia;");
        textField3.setPrefSize(200, 100);
        hBox3.getChildren().addAll(label2, textField3);


        this.textField1 = textField1;
        this.textField3 = textField3;

        EnterGameButton button = new EnterGameButton(this);
        button.setBackground(startLabelBackground);
        button.setTranslateX(350);
        button.setTranslateY(140);
        button.setPrefSize(200, 100);
        mainPane.getChildren().add(button);
    }

    public void setNameOfOnePlayer() {
        playerCreator.getHumanPlayer1().setName(textField1.getText());
        System.out.println(playerCreator.getHumanPlayer1().getName());
    }

    public void create2PlayersNameScene() {

        create1PlayersNameScene();

        HBox hBox2 = new HBox();
        hBox2.setPrefSize(450, 100);
        hBox2.setTranslateY(-180);
        hBox2.setTranslateX(10);
        mainPane.getChildren().add(hBox2);
        Label label1 = new Label();
        label1.setBackground(secondPlayerLabelBackground);
        label1.setPrefSize(200, 100);
        TextField textField2 = new TextField();
        textField2.setBackground(mainBackground);
        textField2.setPromptText("Enter your name");
        textField2.setStyle("-fx-prompt-text-fill: whitesmoke; -fx-alignment: center; -fx-font-size: 20px; " +
                "-fx-text-fill: whitesmoke; -fx-font-family: Georgia;");
        textField2.setPrefSize(200, 90);
        hBox2.getChildren().addAll(label1, textField2);

        this.textField2 = textField2;
    }

    void addWinningLabel(String name) {
        winningLabel = new Label();
        winningLabel.setBackground(mainBackground);
        winningLabel.setText(name + " WIN!!");
        winningLabel.setStyle("-fx-prompt-text-fill: whitesmoke; -fx-alignment: center; -fx-font-size: 30px; " +
                "-fx-text-fill: whitesmoke; -fx-font-family: Georgia;");
        winningLabel.setPrefSize(450, 100);
        winningLabel.setTranslateY(-400);
        mainPane.getChildren().add(winningLabel);

    }

    public void setNameOfTwoPlayers() {
        setNameOfOnePlayer();
        playerCreator.getHumanPlayer2().setName(textField2.getText());
        System.out.println(playerCreator.getHumanPlayer2().getName());
    }

    public void setMainPaneBackground() {
        mainPane.setBackground(mainBackground);
    }

    public void setNumberOfRowsAndColumns() {

        if (!Pattern.matches("[a-zA-Z]+", textField3.getText()) && textField3.getText().length() <= 2) {
            if (!textField3.getText().equals("")) {
                if ((Integer.parseInt(textField3.getText()) > 3)) {
                    setSizeOfGame(Integer.parseInt(textField3.getText()));
                } else {
                    setSizeOfGame(3);
                }
            } else {
                setSizeOfGame(3);
            }
        } else {
            setSizeOfGame(3);
        }
    }

    public Board getBoard() {
        return board;
    }

    public PlayerCreator getPlayerCreator() {
        return playerCreator;
    }

    Label getPlayer1ScoreLabel() {
        return player1ScoreLabel;
    }

    Label getPlayer2ScoreLabel() {
        return player2ScoreLabel;
    }

    public Pane getMainPane() {
        return mainPane;
    }

    public int getSizeOfGame() {
        return sizeOfGame;
    }

    public void setSizeOfGame(int sizeOfGame) {
        this.sizeOfGame = sizeOfGame;
    }

    public Background getMainBackground() {
        return mainBackground;
    }

    public Label getWinningLabel() {
        return winningLabel;
    }

    public SaveButton getSaveButton() {
        return saveButton;
    }
}