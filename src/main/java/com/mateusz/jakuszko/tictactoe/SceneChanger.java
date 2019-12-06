package com.mateusz.jakuszko.tictactoe;

import com.mateusz.jakuszko.tictactoe.buttons.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SceneChanger {

    private Image gameNameImage = new Image("file:resources/gameName.jpg");
    private Image exitImage = new Image("file:resources/ExitGame.jpg");

    private static PlayerCreator playerCreator = new PlayerCreator();
    private static Board board;
    private TextField textField1;
    private TextField textField2;
    private Pane mainPane;
    private Stage mainStage;
    private Label player1ScoreLabel;
    private Label Player2ScoreLabel;
    private Background defaultBackground;

    public SceneChanger(Pane mainPane, Stage mainStage) {
        this.mainStage = mainStage;
        this.mainPane = mainPane;
        this.defaultBackground = mainPane.getBackground();
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


        ExitButton menuButton3 = new ExitButton(mainStage);
        menuButton3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
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
        mainPane.getChildren().add(menuButton3);

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


        Player2ScoreLabel = new Label();
        Player2ScoreLabel.setPrefSize(225, 90);
        Player2ScoreLabel.setTranslateX(0);
        Player2ScoreLabel.setPadding(new Insets(10));
        Player2ScoreLabel.setAlignment(Pos.CENTER);
        Player2ScoreLabel.setMaxWidth(225);
        Player2ScoreLabel.setTextFill(Color.GREEN);
        Player2ScoreLabel.setFont(Font.font(25));
        Player2ScoreLabel.setTextAlignment(TextAlignment.CENTER);

        if (playerCreator.getHumanPlayer2() != null) {
            Player2ScoreLabel.setText(playerCreator.getHumanPlayer2().getName() + ": " + playerCreator.getHumanPlayer2().getScore());
        } else {
            Player2ScoreLabel.setText(playerCreator.getComputerPlayer().getName() + ": " + playerCreator.getComputerPlayer().getScore());
        }


        hBox.getChildren().add(player1ScoreLabel);
        hBox.getChildren().add(Player2ScoreLabel);
        board = new Board(this);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mainPane.getChildren().add(board.getBoardButtons()[i][j]);
            }
        }

        RestartButton restartButton = new RestartButton(this);
        restartButton.setPrefSize(100, 100);
        restartButton.setTranslateY(-325);
        mainPane.getChildren().add(restartButton);

        NextGameButton nextButton = new NextGameButton(this);
        nextButton.setPrefSize(100, 100);
        nextButton.setTranslateX(450);
        nextButton.setTranslateY(-350);
        mainPane.getChildren().add(nextButton);

        ExitButton exitButton = new ExitButton(mainStage);
        exitButton.setPrefSize(100, 100);
        exitButton.setBlendMode(BlendMode.SOFT_LIGHT);
        exitButton.setTranslateX(350);
        exitButton.setTranslateY(-100);
        mainPane.getChildren().add(exitButton);
    }

    public void create1PlayersNameScene() {

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


        EnterGameButton button = new EnterGameButton(this);
        button.setTranslateX(200);
        button.setTranslateY(300);
        button.setPrefSize(200, 80);
        mainPane.getChildren().add(button);
    }

    public void setNameOfOnePlayer() {
        playerCreator.getHumanPlayer1().setName(textField1.getText());
        System.out.println(playerCreator.getHumanPlayer1().getName());
    }

    public void create2PlayersNameScene() {

        create1PlayersNameScene();

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
    
    public void addWinningText() {
        mainPane.setBackground(new Background(new BackgroundImage(gameNameImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
               BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }

    public void setNameOfTwoPlayers() {
        setNameOfOnePlayer();
        playerCreator.getHumanPlayer2().setName(textField2.getText());
        System.out.println(playerCreator.getHumanPlayer2().getName());
    }

    public Board getBoard() {
        return board;
    }

    public PlayerCreator getPlayerCreator() {
        return playerCreator;
    }

    public Label getPlayer1ScoreLabel() {
        return player1ScoreLabel;
    }

    public Label getPlayer2ScoreLabel() {
        return Player2ScoreLabel;
    }

    public Pane getMainPane() {
        return mainPane;
    }

    public Background getDefaultBackground() {
        return defaultBackground;
    }
}


