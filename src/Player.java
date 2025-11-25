public class Player {
    int startingPostion = 0;
    int endingPosition = 0;
    int turns = 0;
    String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void move(){
//        Some logic that takes position and moves it by number of dice
    }
}
