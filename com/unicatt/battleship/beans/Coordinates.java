package com.unicatt.battleship.beans;

import java.util.Objects;

// 2D coordinate system of the board.
public class Coordinates
{
    // The X axis coordinate of the board
    public int x;

    // The Y coordinate represented.
    public int y;

    public Coordinates()
    {
        x = 0;
        y = 0;
    }

    public Coordinates(int horizontalCoordinate, int verticalCoordinate)
    {
       this.x = horizontalCoordinate;
       this.y = verticalCoordinate;
    }

    public void add(Coordinates other)
    {
        x += other.x;
        y += other.y;
    }

    public static Coordinates add(Coordinates lv, Coordinates rv)
    {
        Coordinates result = new Coordinates();
        result.x = lv.x + rv.x;
        result.y = lv.y + rv.x;
        return result;
    }

    public void subtract(Coordinates other)
    {
        x -= other.x;
        y -= other.y;
    }

    public static Coordinates subtract(Coordinates lv, Coordinates rv)
    {
        Coordinates result = new Coordinates();
        result.x = lv.x - rv.x;
        result.y = lv.y - rv.y;
        return result;
    }

    @Override
    public boolean equals(Object o)
    {
        Coordinates other = (Coordinates) o;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" +
                "X=" + x +
                ", Y=" + y +
                ')';
    }
}
