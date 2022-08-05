import java.util.Scanner;

public class Game {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to Game!!!");
        // choosing different game
        PG pg = new SnakeAndLadderPG();
        pg.run();
    }
}
