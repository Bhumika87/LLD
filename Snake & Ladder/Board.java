import java.util.*;

public class Board {
    private final int size;
    private final Map<Integer, Integer> jumpMap = new HashMap<>();

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size; //100

        for (Snake s : snakes) {
            jumpMap.put(s.getStart(), s.getEnd());
        }
        for (Ladder l : ladders) {
            jumpMap.put(l.getStart(), l.getEnd());
        }
    }

    public int getNextPosition(int pos) {
        return jumpMap.getOrDefault(pos, pos);
    }

    public int getSize() {
        return size;
    }
}
