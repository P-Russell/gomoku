//Eval = w1 £ # five-in-row +w2 £ # straight-four
//        +w3 £ # four-in-row +w4 £ # three-in-row +w5 £ #
//        broken-three +w6 £ # two-in-row +w7 £ # single marks


public class Heuristic {

    public static int boardValue(Board board) {

        int weightFive = 500000;
        int unRefutableWeight = 2000;
        int weightFour = 270;
        int weightThree = 90;
        int weightBrokenThree = 30;
        int weightTwo = 10;
        int weightOne = 1;
        Counts attackCount = new Counts(board, board.getLastPlayed());
        Counts defendCount = new Counts(board, (board.getLastPlayed() == 1) ? 2 : 1);

        int attackValue = weightFive * attackCount.fiveInRow +
                unRefutableWeight * attackCount.unRefutable +
                weightFour * attackCount.fourInRow +
                weightThree * attackCount.threeInRow +
                weightBrokenThree * attackCount.brokenThrees +
                weightTwo * attackCount.twoInRow +
                weightOne * attackCount.ones;

        int defendValue = weightFive * defendCount.fiveInRow +
                unRefutableWeight * defendCount.unRefutable +
                weightFour * defendCount.fourInRow +
                weightThree * defendCount.threeInRow +
                weightBrokenThree * defendCount.brokenThrees +
                weightTwo * defendCount.twoInRow +
                weightOne * defendCount.ones;

        int boardValue = attackValue - defendValue;

        if (attackCount.fiveInRow > 0)
            return 500000;
        if (defendCount.fiveInRow > 0)
            return -500000;

        //TerminalGame.printBoard(board.getBoard());
        //System.out.println("Board value of above: " + boardValue);
        //System.out.println("Attack value: " + attackValue + " Defend value: " + defendValue);
        return boardValue;
    }
}