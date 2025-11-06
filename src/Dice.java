import java.util.Random;

public class Dice {

    private int sides;
    private int numberOfDice;
    private Random random;


    public Dice(int sides, int numberOfDice, Random random) {
        this.sides = sides;
        this.numberOfDice = numberOfDice;
        this.random = random;
    }
}
