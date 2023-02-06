import domain.ClassicBoard;
import domain.MoveSymbol;
import domain.Player;
import java.util.HashSet;
import java.util.Set;
import service.GameService;
import service.GameValidatorService;

public class Main {

    public static Set<Player> createPlayers()
    {
        var player1 = new Player(MoveSymbol.O_MOVE);
        var player2 = new Player(MoveSymbol.X_MOVE);

        Set<Player> players = new HashSet<>();
        players.add(player1); players.add(player2);

        return players;
    }
    public static void main(String[] args) throws InterruptedException {
        var board = new ClassicBoard();
        var validator = new GameValidatorService(3);
        var players = createPlayers();


        var gameService = new GameService(board, players, validator);
        gameService.play();
    }
}