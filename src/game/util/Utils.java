package game.util;

import game.model.Pawn;

import java.util.List;

public class Utils {

    public static Pawn getPawn(int x, int y, List<Pawn> pawns) {
        for (Pawn pawn : pawns) {
            if (pawn.getX() == x && pawn.getY() == y) {
                return pawn;
            }
        }
        return null;
    }

}
