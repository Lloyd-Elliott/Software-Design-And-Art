import java.util.Random;

public class Dice {

    private DiceRollStratergy diceRollStratergy;

    public Dice(DiceRollStratergy diceRollStratergy) {
        this.diceRollStratergy = diceRollStratergy;
        }

        public int roll() {
            return diceRollStratergy.rollDice();
        }

    }

