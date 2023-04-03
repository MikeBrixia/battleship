package com.unicatt.battleship;

import com.unicatt.battleship.beans.BoardCell;
import com.unicatt.battleship.beans.Coordinates;
import com.unicatt.battleship.core.Board;
import com.unicatt.battleship.core.GameSession;
import com.unicatt.battleship.core.Ship;
import com.unicatt.battleship.core.ShipComponent;
import java.util.Scanner;

public class Main
{

    private GameSession currentSession;

    public static void main(String[] args)
    {
        ShipComponent component0 = new ShipComponent(2, 5);
        ShipComponent component1 = new ShipComponent(3, 5);
        ShipComponent component2 = new ShipComponent(1, 5);

        Ship ship = new Ship(component0, component1, component2);

        Board gameBoard = new Board(10, 10);
        BoardCell cell = gameBoard.getCell(3, 5);

        gameBoard.placeShip(ship);

        System.out.println(cell.getShipComponent().isHit());

        // Keep updating the game as long as it is not finished.
        while(!gameOver)
        {

        }
    }

    public void update()
    {
        Coordinates inputCoordinates = readInput();
    }

    public Coordinates readInput()
    {
        boolean validInput = false;
        Coordinates inputCoordinates = null;

        // Loop as long as the user input is not valid.
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

}

