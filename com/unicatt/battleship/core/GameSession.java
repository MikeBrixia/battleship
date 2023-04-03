package com.unicatt.battleship.core;

import com.unicatt.battleship.beans.Player;

public class GameSession
{

    private Player[] players;
    private int currentAttempts;
    private int maxAttempts;

    public GameSession(Player[] players, int maxAttempts)
    {
        this.players = players;
        this.currentAttempts = 0;
        this.maxAttempts = maxAttempts;
    }

    public void update()
    {

    }

    public void readPlayerInput()
    {

    }

    public boolean isGameOver()
    {
        return currentAttempts >= maxAttempts;
    }
}
