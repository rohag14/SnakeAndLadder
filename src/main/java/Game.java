import java.util.Scanner;

public class Game {

    static Scanner sc = new Scanner(System.in);

    public static void run(Player p1, Player p2){
        int turn = 0, maxTurns = 1000;
        PlayGround.render();
        System.out.println("Both players are at 0");
        while(turn < maxTurns) {
            System.out.println("Turn for" + turn%2 + " Press any character and then Enter!!");
            sc.next();

            int diceRoll = Dice.roll();
            System.out.println("Congrats you got: " + diceRoll);
            if (turn % 2 == 1) {
                p2.play(diceRoll);
            }
            else {
                p1.play(diceRoll);
            }
            PlayGround.render();
            turn++;
        }
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Snake And Ladder!!!!!!!!");
        Player p1 = new Player("A", 1);
        Player p2 = new Player("B", 2);
        run(p1,p2);
    }
}
