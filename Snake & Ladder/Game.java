import java.util.LinkedList;
import java.util.*;

class Game {
    private final Board board;
    private final Dice dice;
    private final Queue<Player> players;

    public Game(Board board, Dice dice, List<Player> players) {
        this.board = board;
        this.dice = dice;
        this.players = new LinkedList<>(players);
    }

    public void start() {
        while (true) {
            Player current = players.poll();

            int roll = dice.roll();
            int nextPos = current.getPosition() + roll;

            if (nextPos <= board.getSize()) {
                nextPos = board.getNextPosition(nextPos);
                current.setPosition(nextPos);
            }

            System.out.println(current.getName() + " rolled " + roll + " and moved to " + current.getPosition());

            if (nextPos == board.getSize()) {
                System.out.println(current.getName() + " wins!");
                break;
            }

            players.offer(current);
        }
    }
}
