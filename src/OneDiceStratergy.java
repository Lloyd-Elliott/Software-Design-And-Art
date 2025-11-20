import java.util.Random;

public class OneDiceStratergy implements DiceRollStratergy{

    private int sides = 6;
    private final Random random;

    public OneDiceStratergy() {
        this.random = new Random();
    }

    @Override
    public int rollDice() {
        return random.nextInt(sides) + 1;
    }
}
