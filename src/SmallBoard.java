//public class SmallBoard implements BoardStratergy{
//    //    commit
//
//    private final Player player1 = new Player();
//    private final Player player2 = new Player();
//
//    private final static int[] board = new int[]{
//            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,18, 1, 2, 3,
//            10, 11, 12, 13, 14, 15, 16, 17, 18, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3
//    };
//
//    private int currentIndex = 0;
//    private int currentIndex2= 21;
//
//    private int startOfTailIndex = 18;
//    private int endOfTailIndex = 20;
//    private int startOfTailIndex2 = 39;
//    private int endOfTailIndex2 = 41;
//
//    public int getCurrentIndex() {
//        return currentIndex;
//    }
//
//    public void setCurrentIndex(int currentIndex) {
//        this.currentIndex = currentIndex;
//    }
//
//    public int getCurrentIndex2() {
//        return currentIndex2;
//    }
//
//    public void setCurrentIndex2(int currentIndex2) {
//        this.currentIndex2 = currentIndex2;
//    }
//
//    public int getStartOfTailIndex() {
//        return startOfTailIndex;
//    }
//
//    public void setStartOfTailIndex(int startOfTailIndex) {
//        this.startOfTailIndex = startOfTailIndex;
//    }
//
//    public int getEndOfTailIndex() {
//        return endOfTailIndex;
//    }
//
//    public void setEndOfTailIndex(int endOfTailIndex) {
//        this.endOfTailIndex = endOfTailIndex;
//    }
//
//    public int getStartOfTailIndex2() {
//        return startOfTailIndex2;
//    }
//
//    public void setStartOfTailIndex2(int startOfTailIndex2) {
//        this.startOfTailIndex2 = startOfTailIndex2;
//    }
//
//    public int getEndOfTailIndex2() {
//        return endOfTailIndex2;
//    }
//
//    public void setEndOfTailIndex2(int endOfTailIndex2) {
//        this.endOfTailIndex2 = endOfTailIndex2;
//    }
//
//    @Override
//    public void movePlayer(int moves) {
//        player1.setStartingPostion(currentIndex);
//        player2.setStartingPostion(currentIndex2);
//
//        if (player1.getTurns() > player2.getTurns() || player1.getTurns() == player2.getTurns()){
//            player1.setStartingPostion(player1.getStartingPostion() + moves);
//            player1.setTurns(player1.getTurns()+ 1);
//            System.out.println("I move player 1 by " + moves);
//        } else{
//            player2.setStartingPostion(player2.getStartingPostion() + moves);
//            player2.setTurns(player2.getTurns()+ 1);
//
//        };
//
//    }
//
//    @Override
//    public void setupBoard() {
//
//
//        System.out.println("Setting up a small board.");
//    }
//}

public class SmallBoard implements BoardStratergy {

    // Players
    private final Player player1 = new Player("P1");
    private final Player player2 = new Player("P2");

    // Game over flag
    private boolean gameOver = false;

    // Board tiles (for demonstration, integers)
    private final static int[] board = new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18,
            1, 2, 3, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 1, 2, 3, 4, 5, 6, 7,
            8, 9, 1, 2, 3
    };

    // Current player positions
    private int currentIndex1 = 0;
    private int currentIndex2 = 21;

    // Tail positions
    private final int startTail1 = 18;
    private final int endTail1 = 20;
    private final int startTail2 = 39;
    private final int endTail2 = 41;

    // Winning index
    private final int WINNING_INDEX = board.length - 1;

    // -------------------------------
    // Board setup
    // -------------------------------
    @Override
    public void setupBoard() {
        currentIndex1 = 0;
        currentIndex2 = 21;
        player1.setStartingPostion(currentIndex1);
        player2.setStartingPostion(currentIndex2);
        player1.setTurns(0);
        player2.setTurns(0);
        gameOver = false;

        System.out.println("Setting up a small board...");
        System.out.println("Player 1 starts at index " + currentIndex1);
        System.out.println("Player 2 starts at index " + currentIndex2);
    }

    // -------------------------------
    // Move a player based on dice roll
    // -------------------------------
    @Override
    public void movePlayer(int moves) {
        if (gameOver) return;

        Player currentPlayer;
        int newIndex;

        // Determine current player
        if (player1.getTurns() <= player2.getTurns()) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }

        int currentIndex = currentPlayer.getStartingPostion();

        System.out.println("\n" + currentPlayer.getName() + " rolling...");
        System.out.println("They rolled: " + moves);

        // Calculate tentative new index
        newIndex = currentIndex + moves;

        // Cap at board length
        if (newIndex >= board.length) newIndex = board.length - 1;

        // Tail check
        if (newIndex == startTail1) newIndex = handleTail(currentPlayer, startTail1, endTail1);
        else if (newIndex == startTail2) newIndex = handleTail(currentPlayer, startTail2, endTail2);

        // Commit the move
        currentPlayer.setStartingPostion(newIndex);
        currentPlayer.setTurns(currentPlayer.getTurns() + 1);

        // Update board indices for bookkeeping
        if (currentPlayer == player1) currentIndex1 = newIndex;
        else currentIndex2 = newIndex;

        System.out.println(currentPlayer.getName() + " moved to index: " + newIndex);

        // Win check
        if (currentPlayer == player1 && currentPlayer.getStartingPostion() >= endTail1 || currentPlayer == player2 && currentPlayer.getStartingPostion() >= endTail2 ) {
            System.out.println("\n🎉🎉 " + currentPlayer.getName() + " WINS THE GAME! 🎉🎉");
            gameOver = true;
        }
    }

    // -------------------------------
    // Tail handling
    // -------------------------------
    private int handleTail(Player player, int start, int end) {
        System.out.println(player.getName() + " is sliding down the tail...");
        return end;
    }

    // -------------------------------
    // Check if game has a winner
    // -------------------------------
    @Override
    public boolean hasWinner() {
        return gameOver;
    }
}


