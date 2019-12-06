package com.mateusz.jakuszko.tictactoe;

public abstract class Player {
    private String name;
    private int score;



    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addPoint() {
        score++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
