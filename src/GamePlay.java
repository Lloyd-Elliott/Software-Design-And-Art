public class GamePlay {
    public Game Game;

    public GamePlay(Game game) {
        this.Game = game;
    }

    public void playGame() {
        int result = Game.dice.roll();
        Game.board.movePlayer(result);

    }

    }

