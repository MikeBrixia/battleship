package com.unicatt.battleship.core;
import com.unicatt.battleship.beans.BoardCell;
import com.unicatt.battleship.beans.Coordinates;
import com.unicatt.battleship.beans.IDamageable;

public class ShipComponent
{
    /*** The board cell on which this component has been placed */
    public Coordinates coordinates;

    /** * The ship to which this component is attached/part of. */
    private Ship parentShip;

    /** Has this cell already been hit by the player? */
    private boolean isHit;

    public ShipComponent(Coordinates coordinates)
    {
        this.coordinates = coordinates;
    }

    public ShipComponent(int x, int y)
    {
        this.coordinates = new Coordinates(x, y);
    }

    public ShipComponent(Coordinates coordinates, Ship parentShip)
    {
        this.coordinates = coordinates;
        this.parentShip = parentShip;
    }

    public ShipComponent(int x, int y, Ship parentShip)
    {
        this.coordinates = new Coordinates(x, y);
        this.parentShip = parentShip;
    }

    /** Set of this component has been hit or not */
    public void setHit(boolean isHit)
    {
        this.isHit = isHit;
        IDamageable ship = parentShip;
        if(isHit && ship != null)
            ship.OnReceiveHit();
    }

    /**
     * Has this ship component already been hit?
     * @return true if component was already hit, false otherwise
     */
    public boolean isHit()
    {
        return isHit;
    }

    public Coordinates getCoordinates()
    {
        return coordinates;
    }

    public void setParentShip(Ship parentShip)
    {
        this.parentShip = parentShip;
    }

    public Ship getParentShip()
    {
        return parentShip;
    }
}
