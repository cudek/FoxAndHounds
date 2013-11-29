package game.main;

import game.graphics.Drawer;
import game.graphics.SwingDrawer;
import game.input.IllegalActionException;
import game.input.WolfInputReader;
import game.logic.Logic;
import game.logic.MoveDirection;
import game.model.Pawn;
import game.model.PawnType;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private static int HOUNDS_NUMBER = 4;

    private List<Pawn> hounds = new LinkedList<Pawn>();
    private Pawn fox = new Pawn(PawnType.FOX);

    private List<Pawn> pawns = new LinkedList<Pawn>();

    private WolfInputReader wolfInputReader;

    private Drawer drawer;

    private Logic logic;

    public Game() {
        logic = new Logic(this);
        drawer = new SwingDrawer(this);
        wolfInputReader = new WolfInputReader(this);
        createPawns();
        initializeGame();

    }

    public void createPawns() {
        for (int i = 0; i < HOUNDS_NUMBER; ++i) {
            Pawn hound = new Pawn(PawnType.HOUND);
            hounds.add(hound);
            pawns.add(hound);
        }
        pawns.add(fox);
    }

    public void start() {
        drawer.drawGameBoard();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                return false;
            }
        });
    }

    public void initializeGame() {
        for (int i = 0; i < HOUNDS_NUMBER; ++i) {
            hounds.get(i).setPosition(i * 2, 0);
        }
        fox.setPosition(7, 7);
    }

    public void restart() {
        initializeGame();
        drawer.drawGameBoard();
    }

    public void makeMove(Pawn pawn, MoveDirection moveDirection) throws IllegalActionException {
        if (!logic.isMoveLegal(pawn, moveDirection)) {
            throw new IllegalActionException();
        }
        logic.move(fox, moveDirection);
        drawer.drawGameBoard();

        logic.moveHound();
        drawer.drawGameBoard();
    }

    public List<Pawn> getHounds() {
        return hounds;
    }

    public Pawn getFox() {
        return fox;
    }

    public Logic getLogic() {
        return logic;
    }

    public WolfInputReader getWolfInputReader() {
        return wolfInputReader;
    }

    public Drawer getDrawer() {
        return drawer;
    }

    public List<Pawn> getPawns() {
        return pawns;
    }

}
