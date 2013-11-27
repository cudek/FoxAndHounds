package game.logic;

import game.model.Pawn;

public class Movement {
    private Pawn pawn;
    private int toX;
    private int toY;

    public Movement(Pawn pawn, int toX, int toY) {
        super();
        this.pawn = pawn;
        this.toX = toX;
        this.toY = toY;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public int getToX() {
        return toX;
    }

    public void setToX(int toX) {
        this.toX = toX;
    }

    public int getToY() {
        return toY;
    }

    public void setToY(int toY) {
        this.toY = toY;
    }

}
