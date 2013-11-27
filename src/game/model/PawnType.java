package game.model;

public enum PawnType {
    FOX('F'), HOUND('H');

    char symbol;

    private PawnType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

}
