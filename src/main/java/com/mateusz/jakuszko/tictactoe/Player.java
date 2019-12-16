package com.mateusz.jakuszko.tictactoe;

import java.io.Serializable;

public abstract class Player implements Serializable {
    private static final long serialVersionUID = -7474096361843092258L;
    private String name;
    private int score;
    private int id = 0;


    String getName() {
        return name;
    }

    int getScore() {
        return score;
    }

    void addPoint() {
        score++;
    }

    void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public abstract int getId();
}
