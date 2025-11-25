public class EndRulesStratergy implements RulesStratergy{

    private final Board board;

    public EndRulesStratergy(Board board) {
        this.board = board;
    }



    @Override
    public void endOfGame() {
        // Check exact position win
        if (board.getCurrentIndex1() == board.getEndIndex1()) {
            System.out.println("P1 WINS!");
            board.setGameOver(true);
        } else if (board.getCurrentIndex2() == board.getEndIndex2()) {
            System.out.println("P2 WINS!");
            board.setGameOver(true);
        }
    }
}
