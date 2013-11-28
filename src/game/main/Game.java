package game.main;

import game.graphics.Drawer;
import game.graphics.SwingDrawer;
import game.input.IllegalActionException;
import game.input.WolfInputReader;
import game.logic.Logic;
import game.logic.MoveDirection;
import game.logic.Movement;
import game.logic.swipl.HoundActionChooser;
import game.model.Pawn;
import game.model.PawnType;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int HOUNDS_NUMBER = 4;

    private List<Pawn> hounds = new ArrayList<Pawn>(HOUNDS_NUMBER);
    private Pawn fox = new Pawn(7, 7, PawnType.FOX);

    private WolfInputReader wolfInputReader;
    private HoundActionChooser houndActionChooser = new HoundActionChooser();

    private Drawer drawer;

    private Logic logic;

    public Game() {
        for (int i = 0; i < HOUNDS_NUMBER; ++i) {
            hounds.add(new Pawn(i * 2, 0, PawnType.HOUND));
        }
        logic = new Logic(this);
        drawer = new SwingDrawer(this);
        wolfInputReader = new WolfInputReader(this);
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

    public void makeMove(Pawn pawn, MoveDirection moveDirection) throws IllegalActionException {
        if (!logic.isMoveLegal(pawn, moveDirection)) {
            throw new IllegalActionException();
        }
        logic.move(fox, moveDirection);
        drawer.drawGameBoard();

        Movement movement = houndActionChooser.getHoundAction(hounds, fox);
        movement.getPawn().setX(movement.getToX());
        movement.getPawn().setY(movement.getToY());
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

}
