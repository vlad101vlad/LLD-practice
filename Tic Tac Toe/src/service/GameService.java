package service;

import domain.Board;
import domain.Player;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class GameService {
    private Board board;
    private Set<Player> players;
    private GameValidatorService gameValidatorService;

    public GameService(Board board, Set<Player> players, GameValidatorService gameValidatorService) {
        this.board = board;
        this.players = players;
        this.gameValidatorService = gameValidatorService;
    }

    public void play() throws InterruptedException {
        while(!board.getAvailableMoves().isEmpty()) {
            var iterator = players.iterator();

            while (iterator.hasNext() && !board.getAvailableMoves().isEmpty()) {
                var currentPlayer = iterator.next();
                makeMove(currentPlayer, board);
                print(board);
                if(gameValidatorService.findWin(board)) {
                    System.out.println("FOUND A WIN");
                    break;
                }
            }
        }
    }

    private void makeMove(Player player, Board board) {
        var availableMoves = board.getAvailableMoves();
        var randomMove = ThreadLocalRandom.current().nextInt(0, availableMoves.size());
        board.registerMove(availableMoves.get(randomMove), player.getMoveSymbol());
    }

    private void print(Board board){
        System.out.println(board);
        System.out.println("~~~~~~~~");
        System.out.println(board.getMoveIDBoard());
        System.out.println("~~~~~~~~END OF TURN~~~~~~~~");
    }
}
