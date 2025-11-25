import java.util.ArrayList;
import java.util.List;

public class SmallBoard implements BoardStratergy {

    private final Player player1 = new Player("P1");
    private final Player player2 = new Player("P2");

    private boolean gameOver = false;

    private final static int[] board = new int[]{
            1,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,16,17,18,
            1,2,3,10,11,12,13,14,15,
            16,17,18,1,2,3,4,5,6,7,
            8,9,1,2,3
    };

    private int currentIndex1 = 0;
    private int currentIndex2 = 21;

    public int getCurrentIndex1() { return currentIndex1; }
    public int getCurrentIndex2() { return currentIndex2; }

    private final int endTail1 = 20;
    private final int endTail2 = 41;

    public int getEndIndex1() { return endTail1; }
    public int getEndIndex2() { return endTail2; }

    private final List<BoardObserver> observers = new ArrayList<>();

    @Override
    public void setupBoard() {
        currentIndex1 = 0;
        currentIndex2 = 21;
        player1.setStartingPosition(0);
        player2.setStartingPosition(21);
        player1.setTurns(0);
        player2.setTurns(0);
        gameOver = false;

        System.out.println("Setting up board...");
    }

    @Override
    public void movePlayer(int moves) {
        if (gameOver) return;

        Player currentPlayer = (player1.getTurns() <= player2.getTurns()) ? player1 : player2;
        int previousIndex = currentPlayer.getStartingPosition();
        int endIndex = (currentPlayer == player1) ? endTail1 : endTail2;

        int newIndex = previousIndex + moves;

        // Reset to previous position if overshoot
        if (newIndex > endIndex) {
            newIndex = previousIndex;
            System.out.println(currentPlayer.getName() + " overshot the end and returns to " + newIndex);
        }

        currentPlayer.setStartingPosition(newIndex);
        currentPlayer.setTurns(currentPlayer.getTurns() + 1);

        if (currentPlayer == player1) currentIndex1 = newIndex;
        else currentIndex2 = newIndex;

        System.out.println(currentPlayer.getName()+ " rolled a " + moves);
        System.out.println(currentPlayer.getName() + " moved to: " + newIndex);

        notifyObservers();
    }

    @Override
    public boolean hasWinner() {
        return gameOver;
    }

    public void setGameOver(boolean value) {
        this.gameOver = value;
    }

    @Override
    public void addObserver(BoardObserver obs) {
        observers.add(obs);
    }

    @Override
    public void notifyObservers() {
        for (BoardObserver obs : observers)
            obs.onBoardChanged();
    }
}
