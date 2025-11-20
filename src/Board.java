public class Board {
    private BoardStratergy boardStratergy;

    public Board(BoardStratergy boardStratergy){
        this.boardStratergy = boardStratergy;
    }
    public void movePlayer(int steps) {
        System.out.println("Moving player by " + steps + " steps.");


    }
}
