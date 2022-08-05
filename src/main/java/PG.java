import java.util.List;

public abstract class PG {
    static List<Player> players;
    static Dice dice;
    static List<Cell> matrix;
    abstract boolean update(Player p, int endPos);
    abstract void render();
    abstract void run();
}
