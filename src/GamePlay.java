public class GamePlay {
    //    commit
    public Game game;

    public GamePlay(Game game) {
        this.game = game;
    }

    public void playGame() {
        int round = 1;
        game.board.setupBoard();
        while (!game.board.hasWinner()) {
            System.out.println("\n=== ROUND " + round + " ===");
            int result = game.dice.roll();
            System.out.println("Dice rolled: " + result);
            game.board.movePlayer(result);
            round++;
        }
    }

    }

