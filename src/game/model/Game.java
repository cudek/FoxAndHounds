package game.model;

import game.graphics.Drawer;
import game.input.WolfInputReader;
import game.logic.Logic;
import game.logic.MoveDirection;
import game.logic.Movement;
import game.logic.swipl.HoundActionChooser;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int HOUNDS_NUMBER = 4;

    private List<Pawn> hounds = new ArrayList<Pawn>(HOUNDS_NUMBER);
    private Pawn fox = new Pawn(7, 7, PawnType.FOX);

    private WolfInputReader wolfInputReader = new WolfInputReader();
    private HoundActionChooser houndActionChooser = new HoundActionChooser();

    private Drawer drawer;

    private Logic logic = new Logic();

    public Game() {
        for (int i = 0; i < HOUNDS_NUMBER; ++i) {
            hounds.add(new Pawn(i * 2, 0, PawnType.HOUND));
        }
        drawer = new Drawer(this);
    }

    public void start() {
        drawer.drawGameBoard();
        MoveDirection moveDirection;

        while (true) {
            moveDirection = null;
            while (moveDirection == null) {
                moveDirection = wolfInputReader.getActionCommand();
            }
            logic.move(fox, moveDirection);
            drawer.drawGameBoard();

            Movement movement = houndActionChooser.getHoundAction(hounds, fox);
            movement.getPawn().setX(movement.getToX());
            movement.getPawn().setY(movement.getToY());
            drawer.drawGameBoard();
        }

    }

    public List<Pawn> getHounds() {
        return hounds;
    }

    public Pawn getFox() {
        return fox;
    }

}
