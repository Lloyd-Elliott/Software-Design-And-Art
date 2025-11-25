public class Board {
    private BoardStratergy boardStratergy;


    public Board(BoardStratergy boardStratergy){
        this.boardStratergy = boardStratergy;
    }

    public void setupBoard(){
        boardStratergy.setupBoard();
    }
    public void movePlayer(int steps) {
        boardStratergy.movePlayer(steps);

    }

    public boolean hasWinner(){
        return boardStratergy.hasWinner();
    }

}
