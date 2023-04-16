package com.unicatt.battleship.core;
import com.unicatt.battleship.beans.BoardCell;
import com.unicatt.battleship.beans.Coordinates;
import com.unicatt.battleship.beans.Grid;
import com.unicatt.battleship.beans.ShipComponent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class BattleshipGrid extends JPanel
{
    private Board board;
    private Grid grid;
    private Coordinates position;

    public BattleshipGrid(Board board, Coordinates position)
    {
        this.board = board;
        this.position = position;
        this.grid = new Grid(board.getRows(), board.getColumns(), new Coordinates(50, 50));
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(int x = 0; x < board.getColumns(); x++)
        {
            for(int y = 0; y < board.getRows(); y++)
            {
                // The position of the current cell.
                Coordinates cellPosition = grid.getPosition(x, y);

                Coordinates nextVerticalPosition = grid.getPosition(x, y + 1);
                Coordinates nextHorizontalPosition = grid.getPosition(x + 1, y);

                cellPosition.add(position);
                nextVerticalPosition.add(position);
                nextHorizontalPosition.add(position);

                g.drawLine(cellPosition.x, cellPosition.y, nextVerticalPosition.x, nextVerticalPosition.y);
                g.drawLine(cellPosition.x, cellPosition.y, nextHorizontalPosition.x, nextHorizontalPosition.y);

                Image img;
                Coordinates center = grid.getCellCenter(x, y);

                try
                {
                    BoardCell cell = board.getCell(x, y);
                    // Is the cell hidden to the player?
                    if(!cell.isHidden())
                    {
                        if(cell.getShipComponent() != null)
                        {
                            if(cell.getShipComponent().isHit())
                            {
                                // Has this cell ship component already been hit?
                                img = ImageIO.read(new File("src/com/unicatt/battleship/res/Hit_icon.png"));
                            }
                            else
                            {
                                img = ImageIO.read(new File("src/com/unicatt/battleship/res/NoHit_icon.png"));
                            }
                        }
                        else
                        {
                            img = ImageIO.read(new File("src/com/unicatt/battleship/res/NoHit_icon.png"));
                        }

                        img = img.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                        // Draw correct image.
                        g.drawImage(img, center.x + position.x, center.y + position.y, (img1, flags, x1, y1, width, height) -> false);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
