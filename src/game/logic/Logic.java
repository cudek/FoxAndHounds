package game.logic;

import game.logic.swipl.HoundActionChooser;
import game.main.Game;
import game.model.Pawn;
import game.util.Utils;

import java.awt.Point;

public class Logic {

    private Game game;
    private HoundActionChooser houndActionChooser = new HoundActionChooser();

    public Logic(Game game) {
        this.game = game;
    }

    public void move(Pawn pawn, MoveDirection direction) {
        Point toPoint = getToPoint(pawn, direction);
        pawn.setX(toPoint.x);
        pawn.setY(toPoint.y);
    }

    public void moveHound() {
        Movement movement = houndActionChooser.getHoundAction(game.getHounds(), game.getFox());
        movement.getPawn().setX(movement.getToX());
        movement.getPawn().setY(movement.getToY());
    }

    private Point getToPoint(Pawn pawn, MoveDirection direction) {
        switch (direction) {
        case NORTH_EAST:
            return new Point(pawn.getX() + 1, pawn.getY() + 1);
        case NORTH_WEST:
            return new Point(pawn.getX() + 1, pawn.getY() - 1);
        case SOUTH_EAST:
            return new Point(pawn.getX() - 1, pawn.getY() + 1);
        case SOUTH_WEST:
            return new Point(pawn.getX() - 1, pawn.getY() - 1);
        default:
            throw new NullPointerException();
        }
    }

    public boolean isMoveLegal(Pawn pawn, MoveDirection direction) {
        Point point = getToPoint(pawn, direction);
        return point.x >= 0 && point.x <= 7 && point.y >= 0 && point.y <= 7
                && Utils.getPawn(point.x, point.y, game.getHounds()) == null;
    }
}
