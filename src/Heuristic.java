//Eval = w1 £ # five-in-row +w2 £ # straight-four
//        +w3 £ # four-in-row +w4 £ # three-in-row +w5 £ #
//        broken-three +w6 £ # two-in-row +w7 £ # single marks


public class Heuristic {

    public static int boardValue(Board board) {
        int weightFive = 50;
        int unRefutableWeight = 40;
        int weightFour = 25;
        int weightThree = 16;
        int weightBrokenThree = 8;
        int weightTwo = 10;
        int weightOne = 1;
        Counts count = new Counts(board);

        int boardValue = weightFive * count.fiveInRow +
                unRefutableWeight * count.unRefutable +
                weightFour * count.fourInRow +
                weightThree * count.threeInRow +
                weightBrokenThree * count.brokenThrees +
                weightTwo * count.twoInRow +
                weightOne * count.ones;
        return boardValue;
    }
}