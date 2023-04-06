package com.unicatt.battleship.beans;

public class Grid
{
    private int width;
    private int height;
    private Coordinates size;

    public Grid(int width, int height, Coordinates size)
    {
        this.width = width;
        this.height = height;
        this.size = size;
    }

    public Coordinates getPosition(int x, int y)
    {
        int positionX = x * size.x;
        int positionY = y * size.y;
        return new Coordinates(positionX, positionY);
    }

    public Coordinates getCellCenter(int x, int y)
    {
        Coordinates position = getPosition(x, y);
        int xCenterPosition = (int) (position.x + size.x * 0.5);
        int yCenterPosition = (int) (position.y + size.y * 0.5);
        return new Coordinates(xCenterPosition, yCenterPosition);
    }

    public int getX(Coordinates position)
    {
        return position.x / size.x;
    }

    public int getY(Coordinates position)
    {
        return position.y / size.y;
    }

}
