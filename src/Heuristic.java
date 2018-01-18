//Eval = w1 £ # five-in-row +w2 £ # straight-four
//        +w3 £ # four-in-row +w4 £ # three-in-row +w5 £ #
//        broken-three +w6 £ # two-in-row +w7 £ # single marks


public class Heuristic {
    public int heuristic(Board board) {
        int weightFour = 4;
        int weightThree = 3;
        int weightBrokenThree = 2;
        int weightTwo = 1;

        Counts count = new Counts(board);
        int boardValue = weightFour * count.fourInRow +
                weightThree * count.threeInRow +
                weightBrokenThree * count.brokenThrees +
                weightTwo * count.twoInRow;
//        int boardValue =
//                weightFour * fourInRow(board) +
//                weightThree * threeInRow(board) +
//                weightBrokenThree * brokenThree(board) +
//                weightTwo * twoInRow(board);
        return 0;
    }
}