public class Main {

    public static void main(String[] args) {

        int[][] test = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 2, 0, 2, 0, 0},
                {0, 0, 0, 0, 2, 0, 2, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        Board board = new Board(test, 2, 0, 0);

        int counts = Heuristic.boardValue(board);
        //TestPlay t = new TestPlay();
        //t.loop();
    }
}
