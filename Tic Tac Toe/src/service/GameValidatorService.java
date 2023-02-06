package service;

import domain.Board;
import domain.MoveSymbol;
import java.util.Arrays;

public class GameValidatorService {
    int symbolsInARow;

    public GameValidatorService(int symbolsInARow) {
        this.symbolsInARow = symbolsInARow;
    }

    public boolean findWin(Board board) {
        return winVertically(board) || winHorizontally(board) || winDiagonally(board);
    }

    private boolean winHorizontally(Board board) {
        int columns = board.getBoard()[0].length;
        int rows = board.getBoard().length;
        var matrix = board.getBoard();

        for(int i = 0; i < rows; i++) {
            var xSymbolCount = 0;
            var ySymbolCount = 0;
            for(int j = 0; j < columns; j++) {
                var currentSymbol = matrix[i][j];
                if(currentSymbol.equals(MoveSymbol.X_MOVE))
                    xSymbolCount++;
                if(currentSymbol.equals(MoveSymbol.O_MOVE))
                    ySymbolCount++;
            }
            if(xSymbolCount == symbolsInARow || ySymbolCount == symbolsInARow)
                return true;
        }
        return false;
    }

    private boolean winVertically(Board board) {
        int columns = board.getBoard()[0].length;
        int rows = board.getBoard().length;
        var matrix = board.getBoard();

        for(int i = 0; i < columns; i++) {
            var xSymbolCount = 0;
            var ySymbolCount = 0;

            for(int j = 0; j < rows; j++) {
                var currentSymbol = matrix[j][i];

                if(currentSymbol.equals(MoveSymbol.X_MOVE))
                    xSymbolCount++;
                if(currentSymbol.equals(MoveSymbol.O_MOVE))
                    ySymbolCount++;
            }
            if(xSymbolCount == symbolsInARow || ySymbolCount == symbolsInARow)
                return true;
        }
        return false;
    }

    private boolean winDiagonally(Board board) {
        int columns = board.getBoard()[0].length;
        int rows = board.getBoard().length;
        var matrix = board.getBoard();

        return false;
    }
}
