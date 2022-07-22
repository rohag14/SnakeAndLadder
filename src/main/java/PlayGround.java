import java.util.ArrayList;
import java.util.List;


public class PlayGround {
    static int row = 10;
    static int column = 10;
    static int p1 = 0, p2 = 0;
    List<Player> players = new ArrayList<>();
    List<Snake> snakes = new ArrayList<>();
    List<Ladder> ladders  = new ArrayList<>();
    static List<Cell> matrix = new ArrayList<>();
    static {
        for(int i=0;i<=100;i++) {
            matrix.add(new Cell("N",i,i));
        }
        matrix.set(80, new Cell("SM",80,40));
        matrix.set(40, new Cell("ST",40,40));

        matrix.set(10, new Cell("LT",10,50));
        matrix.set(50,new Cell("LH",50,50));
    }




    public static boolean update(Player p, int endPos) {
        if (endPos > 100) return false;

        Cell cell = matrix.get(endPos);

//        matrix.set(endPos,new Cell(p.name, endPos,endPos));
//        matrix.set(p.pos, new Cell("N", p.pos, p.pos));

        if(cell.type.compareTo("SM") == 0 || cell.type.compareTo("LT") == 0) {
            endPos = cell.endPos;
            p.pos = endPos;
        }
        else {
            p.pos = endPos;
        }

        if (p.name.compareTo("A") == 0) {
            p1 = p.pos;
        }
        else {
            p2 = p.pos;
        }

        return true;
    }

    public static void printItem(String x){
        String s = matrix.get(Integer.parseInt(x)).type;

        if (s.compareTo("N") == 0) {
            s = x;
        }
        if (p1 == Integer.parseInt(x) && p2 == Integer.parseInt(x)){
            s = "AB";
        }
        else if (p1 == Integer.parseInt(x)){
            s = "A";
        }
        else if (p2 == Integer.parseInt(x)){
            s = "B";
        }

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
    public static void render() {

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
}
