package game.input;

import game.logic.MoveDirection;
import game.main.Game;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WolfInputReader {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Game game;

    public WolfInputReader(Game game) {
        this.game = game;
    }

    public MoveDirection getActionCommand() {
        String direction = "";
        try {
            direction = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return getMoveDirection(direction);
    }

    private MoveDirection getMoveDirection(String direction) {
        if (direction.equals("3")) {
            return MoveDirection.NORTH_WEST;
        } else if (direction.equals("9")) {
            return MoveDirection.NORTH_EAST;
        } else if (direction.equals("1")) {
            return MoveDirection.SOUTH_WEST;
        } else if (direction.equals("7")) {
            return MoveDirection.SOUTH_EAST;
        } else {
            return null;
        }
    }

    public void handleUserAction(KeyEvent event) throws UnknownActionException, IllegalActionException {
        MoveDirection moveDirection = getMoveDirection(String.valueOf(event.getKeyChar()));
        if (moveDirection == null) {
            throw new UnknownActionException();
        }
        game.makeMove(game.getFox(), moveDirection);
    }
}
