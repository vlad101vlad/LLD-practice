package domain;

public class Player {
    private MoveSymbol moveSymbol;

    public Player(MoveSymbol moveSymbol) {
        this.moveSymbol = moveSymbol;
    }

    public MoveSymbol getMoveSymbol() {
        return moveSymbol;
    }
}
