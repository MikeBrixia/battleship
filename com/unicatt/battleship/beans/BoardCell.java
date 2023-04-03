package com.unicatt.battleship.beans;

import com.unicatt.battleship.core.ShipComponent;

public class BoardCell
{
    // The X,Y coordinates of the cell on the board.
    private Coordinates coordinates;

    // Is the content of this cell currently hidden to the player?
    private boolean hidden;

    // The ship component contained inside this cell, null if
    // this cell does not contain any ship component.
    private ShipComponent shipComponent;


    public BoardCell(int row, int column)
    {
        this.coordinates = new Coordinates(row, column);
        this.hidden = true;
    }

    public BoardCell(int row, int column, ShipComponent shipComponent)
    {
        this(row, column);
        this.shipComponent = shipComponent;
    }

    /**
     * Hit this cell. N.B. if cell was already hit this method will fail
     * and return false.
     * @return true if cell was hit successfully, false otherwise.
     */
    public boolean hitCell()
    {
        boolean hitResult = false;

        // Is it the first time this cell get hit?
        if(hidden)
        {
            // if was first it, then apply damage to the ship component
            // and mark it as "hit".
            shipComponent.setHit(true);

            // Show the cell on to the player
            hidden = false;
            hitResult = true;
        }
        return hitResult;
    }

    public void placeShipComponent(ShipComponent component)
    {
        if(component != null)
        {
            component.coordinates = coordinates;
            this.shipComponent = component;
        }
    }

    /**
     * Is this cell currently hidden to the player?
     * @return true is this cell is currently hidden, false otherwise.
     */
    public boolean isHidden()
    {
        return hidden;
    }

    /**
     * Get the X,Y coordinates of this cell.
     * @return the row-column coordinates of this cell on the board.
     */
    public Coordinates getCoordinates()
    {
        return coordinates;
    }

    /**
     * Get the ship component placed inside this cell.
     * @return The ship component placed inside this cell.
     */
    public ShipComponent getShipComponent()
    {
        return shipComponent;
    }

    public void setShipComponent(ShipComponent shipComponent)
    {
        this.shipComponent = shipComponent;
    }
}
