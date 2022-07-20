public class Player{
    public String name;
    public int id;
    public int pos;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        this.pos = 0;
    }

    void play(int diceRoll){
        int endPos = this.pos + diceRoll;

        if (PlayGround.update(this, endPos)) {
            System.out.println("Valid Move!!!");
        }
        else {
            System.out.println("Invalid Move!!");
        }
    }
}
