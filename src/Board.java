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

    public int getCurrentIndex1() { return boardStratergy.getCurrentIndex1(); }
    public int getCurrentIndex2() { return boardStratergy.getCurrentIndex2(); }
    public int getEndIndex1() { return boardStratergy.getEndIndex1(); }
    public int getEndIndex2() { return boardStratergy.getEndIndex2(); }

    // ⭐ THIS WAS MISSING
    public void setGameOver(boolean value) {
        boardStratergy.setGameOver(value);
    }

    public void addObserver(BoardObserver obs) {
        boardStratergy.addObserver(obs);
    }

    public void notifyObservers() {
        boardStratergy.notifyObservers();
    }
}
