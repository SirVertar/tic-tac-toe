package com.mateusz.jakuszko.tictactoe;

import com.mateusz.jakuszko.tictactoe.buttons.GameButton;
import com.sun.org.apache.bcel.internal.generic.ARETURN;

public class Board {

    private GameButton[][] boardButtons = createBoardButtons();

    private GameButton[][] createBoardButtons() {
        GameButton[][] temporaryButtons = new GameButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GameButton button = new GameButton();
                button.setId("" + i + j);
                button.setText("" + i + j);
                temporaryButtons[i][j] = button;
            }
        }
        return temporaryButtons;
    }

    public GameButton[][] getBoardButtons() {
        return boardButtons;
    }

    public void setBoardButtons(GameButton[][] boardButtons) {
        this.boardButtons = boardButtons;
    }
}
