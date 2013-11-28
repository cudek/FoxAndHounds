package game.graphics;

import game.graphics.swing.SwingGameBoard;
import game.main.Game;

import java.awt.event.KeyEvent;

public class SwingDrawer implements Drawer {

    private Game game;
    private SwingGameBoard gameBoard;

    public SwingDrawer(Game game) {
        this.game = game;
        gameBoard = new SwingGameBoard(this);
        gameBoard.getGameCanvas().setGame(game);
        gameBoard.display();
    }

    @Override
    public void drawGameBoard() {
        gameBoard.getGameCanvas().repaint();
    }

    public void keyPressed(KeyEvent event) {
        game.getWolfInputReader().handleUserAction(event);
    }

}
