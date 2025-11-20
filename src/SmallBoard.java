public class SmallBoard implements BoardStratergy{
    //    commit

    private final static int[] board = new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,18, 1, 2, 3,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3
    };

    private int currentIndex = 0;
    private int currentIndex2= 21;

    private int startOfTailIndex = 18;
    private int endOfTailIndex = 20;
    private int startOfTailIndex2 = 39;
    private int endOfTailIndex2 = 41;

    @Override
    public void setupBoard() {


        System.out.println("Setting up a small board.");
    }
}
