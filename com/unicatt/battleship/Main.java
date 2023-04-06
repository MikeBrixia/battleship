package com.unicatt.battleship;
import com.unicatt.battleship.beans.Player;
import com.unicatt.battleship.core.BattleshipGrid;
import com.unicatt.battleship.core.Board;
import com.unicatt.battleship.core.GameSession;
import java.awt.*;


public class Main
{
    private GameSession currentSession;

    public static void main(String[] args)
    {
        Board gameBoard = new Board(10, 10);

        Frame window = new Frame();
        window.setVisible(true);
        window.setSize(800, 800);

        BattleshipGrid grid = new BattleshipGrid(gameBoard);
        window.add(grid);

        // Create a new game session with only one player.
        Player player = new Player();
        GameSession session = new GameSession(player, 7, gameBoard);

        // Begin game loop.
        session.gameLoop();

    }

}

