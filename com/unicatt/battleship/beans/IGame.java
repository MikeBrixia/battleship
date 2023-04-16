package com.unicatt.battleship.beans;

public interface IGame
{
    /**
     * Called when user choose to play this game.
     */
    void playGame();

    /**
     * Has the game finished?
     * @return true if the game has finished, false otherwise.
     */
    boolean hasFinished();

    /**
     * Called when the game begins.
     */
    void onBeginGame();

    /**
     * Called each game update.
     */
    void onUpdate();

    /**
     * Called when the game ends.
     */
    void onGameEnd();
}
