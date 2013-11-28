package game.graphics;

import game.main.Game;
import game.model.Pawn;
import game.util.Utils;

import java.util.LinkedList;
import java.util.List;

public class ConsoleDrawer implements Drawer {

    private Game game;

    private final static char blackFieldSymbol = ' ';
    private final static char whiteFieldSymbol = '.';

    private List<Pawn> pawns;

    public ConsoleDrawer(Game game) {
        this.game = game;
        pawns = new LinkedList<Pawn>(game.getHounds());
        pawns.add(game.getFox());
    }

    private char switchSymbol(char symbol) {
        if (symbol == blackFieldSymbol) {
            return whiteFieldSymbol;
        } else {
            return blackFieldSymbol;
        }
    }

    /* (non-Javadoc)
     * @see game.graphics.Drawer#drawGameBoard()
     */
    @Override
    public void drawGameBoard() {
        char currentSymbol = blackFieldSymbol;
        Pawn pawn = null;
        System.out.println();
        for (int j = 7; j >= 0; --j) {
            for (int i = 0; i < 8; ++i) {
                if ((pawn = Utils.getPawn(i, j, pawns)) == null) {
                    System.out.print(currentSymbol);
                } else {
                    System.out.print(pawn.getPawnType().getSymbol());
                }

                currentSymbol = switchSymbol(currentSymbol);
            }
            currentSymbol = switchSymbol(currentSymbol);
            System.out.println();
        }
    }
}
