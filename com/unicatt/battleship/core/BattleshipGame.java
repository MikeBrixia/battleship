package com.unicatt.battleship.core;
import com.unicatt.battleship.Main;
import com.unicatt.battleship.beans.*;
import com.unicatt.battleship.utils.CommonUtils;

public class BattleshipGame implements IGame
{
    /**
     * Battleship boards, one for each player.
     */
    private Board[] gameBoards;

    private int currentAttempts;

    private int maxAttempts;

    /**
     * All the players involved in the game.
     */
    private Player[] players;

    private final int shipNumber = 10;

    private static final int columns = 10;
    private static final int rows  = 10;

    public BattleshipGame(Player[] players, int maxAttempts)
    {
        this.players = players;
        this.currentAttempts = 0;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void playGame()
    {
        int length = players.length;

        // Initialize game boards, one for each player.
        gameBoards = new Board[length];

        // Create a board for each player.
        for(int i = 0; i < length; i++)
        {
            gameBoards[i] = new Board(columns, rows, new Coordinates(100, 80));
        }

        // Notify that the game has started.
        onBeginGame();
    }

    @Override
    public boolean hasFinished()
    {
        // Is the game finished?
        boolean finished = currentAttempts >= maxAttempts;

        // If true notify that the game is ended.
        if(finished)
        {
            onGameEnd();
        }
        return finished;
    }

    @Override
    public void onBeginGame()
    {
       for(Board board : gameBoards)
       {
           int placedShips = 0;
           while(placedShips < shipNumber)
           {
               // Generate random board coordinates for ship component.
               int x = CommonUtils.getRandomIntegerBetweenRange(0, 9);
               int y = CommonUtils.getRandomIntegerBetweenRange(0, 9);

               // Create ship component
               ShipComponent shipComponent = new ShipComponent(x, y);

               // Place it on the board
               boolean placed = board.placeShip(new Ship(shipComponent));

               // If board was free and ship component was placed successfully,
               // increment the counter of placed ships
               if(placed)
               {
                   placedShips++;
               }
           }
       }
    }

    private void placeRandomShips()
    {
        CommonUtils.getRandomIntegerBetweenRange(0, 10);
    }

    @Override
    public void onUpdate()
    {
        Coordinates coord = (Main.userInput instanceof Coordinates ? (Coordinates) Main.userInput : null);
        if(coord != null)
        {
            gameBoards[0].getCell(coord.x, coord.y).hitCell();
            currentAttempts++;
        }
    }

    @Override
    public void onGameEnd()
    {
        BoardCell cells [][] = gameBoards[0].getBoardCells();
        for(BoardCell[] columns : cells)
        {
            for(BoardCell row : columns)
            {
                row.setHidden(false);
            }
        }
    }

    public Board[] getGameBoards()
    {
        return gameBoards;
    }
}
