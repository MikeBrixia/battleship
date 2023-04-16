package com.unicatt.battleship.core;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class GameWindow
{
    private Frame window;
    private GameSession session;

    public GameWindow(int width, int height, String name, boolean visible, GameSession session)
    {
        // Create and initialize game window.
        window = new Frame();
        window.setVisible(visible);
        window.setSize(width, height);
        window.setTitle(name);

        this.session = session;

        initializeListeners();
    }

    private void initializeListeners()
    {
        // Window resize event callback.
        window.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                super.componentResized(e);
            }
        });
    }

    /**
     * Render the game session content inside the game window.
     */
    public void render()
    {
        BattleshipGame game = session.getGame();
        Board[] boards = game.getGameBoards();
        for(Board board : boards)
        {
            BattleshipGrid grid = board.getGrid();
            grid.repaint(0);
        }
    }

    public Frame getWindow()
    {
        return window;
    }
}
