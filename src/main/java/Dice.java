import java.lang.Math;
public class Dice {
    static int roll(){
        return (int)(Math.random()*6)%6 + 1;
    }
}