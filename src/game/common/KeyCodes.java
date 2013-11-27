package game.common;

public enum KeyCodes {
    ESC((char) 0x1B);

    private char code;

    private KeyCodes(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

}
