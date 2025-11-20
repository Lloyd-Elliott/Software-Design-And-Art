public class Player {
    int startingPostion = 0;
    int endingPosition = 0;

    public Player(int startingPostion, int endingPosition) {
        this.startingPostion = startingPostion;
        this.endingPosition = endingPosition;
    }

    public int getStartingPostion() {
        return startingPostion;
    }

    public int getEndingPosition() {
        return endingPosition;
    }

    public void setStartingPostion(int startingPostion) {
        this.startingPostion = startingPostion;
    }

    public void setEndingPosition(int endingPosition) {
        this.endingPosition = endingPosition;
    }

    public void move(){
//        Some logic that takes position and moves it by number of dice
    }
}
