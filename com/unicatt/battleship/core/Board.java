package com.unicatt.battleship.core;
import com.unicatt.battleship.Main;
import com.unicatt.battleship.beans.BoardCell;
import com.unicatt.battleship.beans.Coordinates;
import com.unicatt.battleship.beans.Ship;
import com.unicatt.battleship.beans.ShipComponent;
import java.util.List;

/**
 * Represents battleship game board, where a player
 * places his ships or tries to destroy the opponent ones.
 */
public class Board
{
    // The width of the game board.
    private int columns;

    // The height of the game board.
    private int rows;

    // All the cells of this board
    private BoardCell[][] boardCells;

    /**
     * The grid data of the board.
     */
    private BattleshipGrid grid;

    public Board(int columns, int rows, Coordinates position)
    {
        this.columns = columns;
        this.rows = rows;
        this.boardCells = new BoardCell[columns][rows];

        // Construct the board cells one by one.
        buildBoard();

        // Create the board grid.
        this.grid = new BattleshipGrid(this, position);
        Main.currentSession.getGameWindow().getWindow().add(this.grid);
    }

    /**
     * Build the board using its row and column data.
     */
    private void buildBoard()
    {
        // for each copy of X, Y coordinates create a board cell.
        for(int column = 0; column < columns; column++)
        {
            for(int row = 0; row < rows; row++)
            {
                this.boardCells[row][column] = new BoardCell(row, column);
            }
        }
    }

    /**
     * Place a ship on this board.
     * @param ship the ship to place on the board
     */
    public boolean placeShip(Ship ship)
    {
        // Get all the components attached to the ship.
        List<ShipComponent> shipComponents = ship.getShipComponents();

        boolean result = false;

        // Place the components of the ship one at a time.
        for(ShipComponent component : shipComponents)
        {
            // Get the coordinates of the ship component we're trying to place
            // on the board.
            Coordinates shipCoordinates = component.getCoordinates();
            BoardCell cell = boardCells[shipCoordinates.x][shipCoordinates.y];

            // Place the ship component inside the cell at X, Y coordinates.
            result = cell.placeShipComponent(component);
        }
        return result;
    }

    /**
     * Get the cell of this board at the supplied X, Y coordinates.
     * @param column the column position of the cell
     * @param row the row position of the cell.
     * @return the cell at (row, column) coordinates.
     */
    public BoardCell getCell(int column, int row)
    {
        return boardCells[column][row];
    }

    /**
     * Get all the cells which composes this board.
     * @return all the cells which composes this board.
     */
    public BoardCell[][] getBoardCells()
    {
        return boardCells;
    }

    public int getColumns()
    {
        return columns;
    }

    public int getRows()
    {
        return rows;
    }

    public BattleshipGrid getGrid() { return grid; }

}
