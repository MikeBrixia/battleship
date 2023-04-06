package com.unicatt.battleship.core;
import com.unicatt.battleship.beans.Coordinates;
import com.unicatt.battleship.beans.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class BattleshipGrid extends Canvas
{
    private Board board;
    private Grid grid;

    public BattleshipGrid(Board board)
    {
        this.board = board;
        this.grid = new Grid(board.getRows(), board.getColumns(), new Coordinates(50, 50));
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        for(int x = 0; x < board.getColumns(); x++)
        {
            for(int y = 0; y < board.getRows(); y++)
            {
                // The position of the current cell.
                Coordinates position = grid.getPosition(x, y);

                // Draw vertical grid lines.
                Coordinates nextVerticalPosition = grid.getPosition(x, y + 1);
                g.drawLine(position.x, position.y, nextVerticalPosition.x, nextVerticalPosition.y);

                // Draw horizontal grid lines.
                Coordinates nextHorizontalPosition = grid.getPosition(x + 1, y);
                g.drawLine(position.x, position.y, nextHorizontalPosition.x, nextHorizontalPosition.y);

                Image img = new BufferedImage(5, 5, Image.SCALE_SMOOTH);
                Coordinates center = grid.getCellCenter(x, y);

                g.drawImage(img, center.x, center.y, (img1, infoflags, x1, y1, width, height) -> false);
            }
        }
    }
}
