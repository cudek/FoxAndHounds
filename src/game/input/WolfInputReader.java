package game.input;

import game.logic.MoveDirection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WolfInputReader {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public MoveDirection getActionCommand() {
        String direction;
        try {
            direction = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (direction.equals("7")) {
            return MoveDirection.NORTH_WEST;
        } else if (direction.equals("9")) {
            return MoveDirection.NORTH_EAST;
        } else if (direction.equals("1")) {
            return MoveDirection.SOUTH_WEST;
        } else if (direction.equals("3")) {
            return MoveDirection.SOUTH_EAST;
        } else {
            return null;
        }
    }
}
