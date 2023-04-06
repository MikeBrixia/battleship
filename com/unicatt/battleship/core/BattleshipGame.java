
package com.unicatt.battleship.core;
import com.unicatt.battleship.beans.Player;


public class BattleshipGame
{
    private Board[] gameBoards;
    private Player[] players;

    public BattleshipGame(Player[] players)
    {
        this.players = players;
        this.gameBoards = new Board[players.length];
    }

    public void createPlayersBoards(int rows, int columns)
    {
        for(int i = 0; i < gameBoards.length; i++)
        {
            gameBoards[i] = new Board(columns, rows);
        }
    }

    public void placeShipRandomlyOnBoard()
    {

    }


}
