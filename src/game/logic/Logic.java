package game.logic;

import game.model.Pawn;

public class Logic {
    public void move(Pawn pawn, MoveDirection direction) {
        switch (direction) {
        case NORTH_EAST:
            pawn.setX(pawn.getX() + 1);
            pawn.setY(pawn.getY() + 1);
            return;
        case NORTH_WEST:
            pawn.setX(pawn.getX() + 1);
            pawn.setY(pawn.getY() - 1);
            return;
        case SOUTH_EAST:
            pawn.setX(pawn.getX() - 1);
            pawn.setY(pawn.getY() + 1);
            return;
        case SOUTH_WEST:
            pawn.setX(pawn.getX() - 1);
            pawn.setY(pawn.getY() - 1);
            return;
        }
    }

}
