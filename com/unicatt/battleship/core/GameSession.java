package com.unicatt.battleship.core;
import com.unicatt.battleship.Main;
import com.unicatt.battleship.beans.Coordinates;
import com.unicatt.battleship.beans.IGame;
import java.util.Scanner;

public class GameSession
{
    /**
     * The game that is being played by the
     * game session.
     */
    private IGame game;

    /**
     * The window used to display the game.
     */
    private GameWindow gameWindow;

    public GameSession(IGame game)
    {
        this.game = game;
        this.gameWindow = new GameWindow(800, 800, "Battleship", true, this);
    }

    public void gameLoop()
    {
        // Begin playing the game.
        game.playGame();

        // Render before starting the game loop.
        gameWindow.render();

        // Keep playing the game as long as it is not finished.
        while(!game.hasFinished())
        {
            // First read inputs.
            Main.userInput = readInput();

            // After reading inputs, update the game.
            game.onUpdate();

            // Finally, after all game updates, render the game on the window.
            gameWindow.render();
        }
    }

    private Coordinates readInput()
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

    public GameWindow getGameWindow()
    {
        return gameWindow;
    }

    public <T> T getGame()
    {
        return (T) game;
    }

}
