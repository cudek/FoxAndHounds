package game.graphics.swing;

import game.main.Game;
import game.model.Pawn;
import game.model.PawnType;
import game.util.Utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GameCanvas extends JPanel {

    private Game game;

    private int fieldPixelSize = 50;
    private int fieldsInRowNumber = 8;
    private Color blackFieldColor = Color.BLACK;
    private Color whiteFieldColor = Color.WHITE;

    private List<Pawn> pawns;

    private Image houndImage;
    private Image foxImage;

    private static final String foxImagePath = "resources/fox.png";
    private static final String houndImagePath = "resources/hound.png";

    public GameCanvas() {
        try {
            houndImage = ImageIO.read(new File(houndImagePath));
            foxImage = ImageIO.read(new File(foxImagePath));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public GameCanvas(Game game) {
        this();
        setupPawns(game);
        this.game = game;
    }

    private void setupPawns(Game game) {
        pawns = new LinkedList<Pawn>(game.getHounds());
        pawns.add(game.getFox());
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D graphicsCopy = (Graphics2D) graphics.create();
        graphicsCopy.setColor(Color.white);
        Point startingPoint = getStartingPoint();
        graphicsCopy.fillRect(startingPoint.x, startingPoint.y, getBoardLength(), getBoardLength());

        Color currentColor = blackFieldColor;
        Pawn pawn = null;
        int margin = getMargin();
        int x, y;
        for (int j = 7; j >= 0; --j) {
            y = fieldPixelSize * fieldsInRowNumber - (j + 1) * fieldPixelSize + margin;
            x = margin;
            for (int i = 0; i < 8; ++i) {
                graphicsCopy.setColor(currentColor);
                drawField(x, y, graphicsCopy);
                if ((pawn = Utils.getPawn(i, j, pawns)) != null) {
                    if (pawn.getPawnType() == PawnType.FOX) {
                        graphicsCopy.drawImage(foxImage, x, y, null);
                    } else {
                        graphicsCopy.drawImage(houndImage, x, y, null);
                    }
                }
                x += fieldPixelSize;
                currentColor = switchSymbol(currentColor);
            }
            currentColor = switchSymbol(currentColor);
        }
    }

    private void drawField(int x, int y, Graphics2D graphics) {
        graphics.fillRect(x, y, fieldPixelSize, fieldPixelSize);
    }

    private Color switchSymbol(Color color) {
        if (color.equals(blackFieldColor)) {
            return whiteFieldColor;
        } else {
            return blackFieldColor;
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
        setupPawns(game);
    }

    public int getBoardLength() {
        return fieldPixelSize * fieldsInRowNumber;
    }

    public Dimension calculateDimension() {
        int length = getBoardLength();
        length += 2 * getMargin();
        return new Dimension(length, length);
    }

    public int getMargin() {
        Border border = getBorder();
        int margin = 0;
        if (border instanceof LineBorder) {
            margin = ((LineBorder) border).getThickness();
        }
        return margin;
    }

    public void setPreferredSize() {
        setPreferredSize(calculateDimension());
    }

    public Point getStartingPoint() {
        int margin = getMargin();
        return new Point(margin, margin);
    }
}
