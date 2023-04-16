package com.unicatt.battleship;
import com.unicatt.battleship.beans.Coordinates;
import com.unicatt.battleship.beans.Player;
import com.unicatt.battleship.core.*;
import com.unicatt.battleship.utils.CommonUtils;

import javax.imageio.ImageIO;
import java.awt.*;

public class Main
{
    public static GameSession currentSession;
    public static Object userInput;

    public static void main(String[] args)
    {
        Player[] players = new Player[1];
        players[0] = new Player();

        BattleshipGame game = new BattleshipGame(players, 5);
        currentSession = new GameSession(game);

        // Create screen instance.
        Frame screen = new Frame();
        screen.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        // Place game window at the center of the screen.
        CommonUtils.centerWindowOnScreen(currentSession.getGameWindow().getWindow(), screen);

        // Start game loop.
        currentSession.gameLoop();

    }
}

