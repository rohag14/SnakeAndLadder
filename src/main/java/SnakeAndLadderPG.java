import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadderPG extends PG{
    int p1 = 0, p2 = 0;
    static Player player1, player2;
    static List<Snake> snakes;
    static List<Ladder> ladders;
    static  {
        player1 = new Player("A",1);
        player2 = new Player("B",2);
        players = new ArrayList<>();
        dice = new Dice();
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        matrix = new ArrayList<>();
        for(int i=0;i<=100;i++) {
            matrix.add(new Cell("N",i,i));
        }

        matrix.set(80, new Cell("SM",80,40));
        matrix.set(40, new Cell("ST",40,40));

        matrix.set(10, new Cell("LT",10,50));
        matrix.set(50,new Cell("LH",50,50));
    }

    @Override
    boolean update(Player p,int endPos) {
        System.out.println(p.id);
        if (endPos > 100) return false;

        Cell cell = matrix.get(endPos);

        if(cell.type.compareTo("SM") == 0 || cell.type.compareTo("LT") == 0) {
            endPos = cell.endPos;
        }
        p.pos = endPos;

//        if (p.name.compareTo("A") == 0) {
//            p1 = p.pos;
//        }
//        else {
//            p2 = p.pos;
//        }

        return true;
    }

    private void printItem(String x){
        String s = matrix.get(Integer.parseInt(x)).type;

        if (s.compareTo("N") == 0) {
            s = x;
        }
        if (player1.pos == Integer.parseInt(x) && player2.pos == Integer.parseInt(x)){
            s = "AB";
        }
        else if (player1.pos == Integer.parseInt(x)){
            s = "A";
        }
        else if (player2.pos == Integer.parseInt(x)){
            s = "B";
        }

//        String s = x;
        int d = s.length();
        if(d==1){
            System.out.print(s);
            System.out.print("  ");
        }
        else if(d==2){
            System.out.print(s);
            System.out.print(" ");
        }
        else{
            System.out.print(s);
        }
    }

    @Override
    void render() {
        int count;
        int flag=0;
        int start = 100;
        for(int i=0;i<21;i++){
            if(i%2==0){
                for(int j=0;j<21;j++){
                    if(j%2==0){
                        System.out.print("+");
                    }
                    else{
                        System.out.print("---");
                    }
                }
            }
            else{
                if(flag==0){
                    count = start;
                    for(int j=0;j<21;j++){
                        if(j%2==0){
                            System.out.print("|");
                        }
                        else{
                            String s=String.valueOf(count);
                            printItem(s);
                            count--;
                        }
                    }
                    flag=1;
                    start-=19;
                }
                else{
                    count=start;
                    for(int j=0;j<21;j++){
                        if(j%2==0){
                            System.out.print("|");
                        }
                        else{
                            String s=String.valueOf(count);
                            printItem(s);
                            count++;
                        }
                    }
                    start--;
                    flag=0;
                }
            }
            System.out.println();
        }
    }

    @Override
    void run() {
        Scanner sc = new Scanner(System.in);
        int turn = 0, maxTurns = 1000;
        render();
        System.out.println("Both players are at 0");

        while(turn < maxTurns) {
            System.out.println("Turn for " + turn % 2 + " Press any character and then Enter!!");
            sc.next();

            int diceRoll = Dice.roll();
            System.out.println("Congrats you got: " + diceRoll);
            if (turn % 2 == 1) {
                update(player2, player2.pos+diceRoll);
//                p2.play(diceRoll,pg);
            }
            else {
                update(player1, player1.pos+diceRoll);

//                p1.play(diceRoll,pg);
            }
            render();
            turn++;
        }
    }
}
