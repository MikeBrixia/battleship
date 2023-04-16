package com.unicatt.battleship.beans;

public class Player
{
    private String name;

    private int score;

    public void incrementScore()
    {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
