package com.unicatt.battleship.core;

import com.unicatt.battleship.beans.BoardCell;
import com.unicatt.battleship.beans.Coordinates;
import com.unicatt.battleship.beans.Player;
import java.util.Scanner;

public class GameSession
{
    private Player player;
    private Board gameBoard;
    private int currentAttempts;
    private int maxAttempts;

    public GameSession(Player player, int maxAttempts, Board gameBoard)
    {
        this.player = player;
        this.currentAttempts = 0;
        this.maxAttempts = maxAttempts;
        this.gameBoard = gameBoard;
    }

    public void gameLoop()
    {
        while(!isGameOver())
        {
            Coordinates inputCoordinates = readPlayerInput();
            update(inputCoordinates);
        }
    }

    /**
     * Update the game with the valid user input.
     */
    public void update(Coordinates coordinates)
    {
        BoardCell cell = gameBoard.getCell(coordinates.x, coordinates.y);
        if(cell.isHidden())
        {
            currentAttempts++;
            boolean hit = cell.hitCell();
            if(hit)
            {
                player.incrementScore();
            }
            else
            {
                System.out.println("No hit, try again!");
            }
        }
        else
        {
            System.out.println("You've already hit that cell!, try again");
        }
    }

    private Coordinates readPlayerInput()
    {
        boolean validInput = false;
        Coordinates inputCoordinates = null;

        // Keep requesting user input as long as is not valid.
        while(!validInput)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Row: ");
                int row = scanner.nextInt();

                System.out.println("Column: ");
                int column = scanner.nextInt();

                inputCoordinates = new Coordinates(row, column);
                validInput = true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return inputCoordinates;
    }

    public boolean isGameOver()
    {
        return currentAttempts >= maxAttempts;
    }
}
