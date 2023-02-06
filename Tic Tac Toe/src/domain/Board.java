package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Board {
    public MoveSymbol[][] getBoard() {
        return board;
    }

    protected MoveSymbol[][] board;
    protected List<Integer> availableMoves = new ArrayList<>();

    public Board(int noRows, int noColumns)
    {
        this.board = new MoveSymbol[noRows][noColumns];
        Arrays.stream(this.board).forEach(row -> Arrays.fill(row, MoveSymbol.EMPTY_SPACE));

        this.initAvailableMoves(noRows * noColumns);
    }

    private void initAvailableMoves(int count){
        for(int i = 0; i < count; i++)
            availableMoves.add(i+1);
    }
    public int getAvailableSpaces() {
        return availableMoves.size();
    }

    public List<Integer> getAvailableMoves()
    {
        return this.availableMoves;
    }

    public void registerMove(int moveID, MoveSymbol moveType)
    {
        this.registerMoveFromMoveID(moveID, moveType);
        this.availableMoves.remove((Object)moveID);
    }

    private void registerMoveFromMoveID(int moveID, MoveSymbol moveSymbol)
    {
            final int MOVE_ID_OFFSET = 1; // Arrays start from 0
            int row = (moveID - MOVE_ID_OFFSET) / board.length;
            int column = (moveID - MOVE_ID_OFFSET) % board[0].length;
            this.board[row][column] = moveSymbol;
    }

    public String getMoveIDBoard()
    {
        AtomicInteger counter = new AtomicInteger(1);
        StringBuilder builder = new StringBuilder();
        Arrays.stream(board).forEach(row -> {
            Arrays.stream(row).forEach(column -> {
                if(column.equals(MoveSymbol.EMPTY_SPACE))
                    builder.append(counter.get()).append(" ");
                else
                    builder.append("_ ");
                counter.getAndIncrement();
            });
            builder.append("\n");
        });

        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(board).forEach(row -> {
            Arrays.stream(row).forEach(column -> {
                switch (column) {
                    case O_MOVE -> builder.append("O ");
                    case X_MOVE -> builder.append("X ");
                    case EMPTY_SPACE -> builder.append("_ ");
                    default -> throw new RuntimeException("Not a valid char");
                }
            });
            builder.append("\n");
        });

        return builder.toString();
    }
}
