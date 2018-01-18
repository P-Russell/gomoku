public class Counts {
    public int fourInRow;
    public int threeInRow;
    public int brokenThrees;
    public int twoInRow;

    public Counts(Board board) {
        int len = board.getBoard().length;
        int[][] examinedHorizontal = new int[len][len];
        int[][] examinedVertical = new int[len][len];
        int[][] examinedLeftDiagonals = new int[len][len];
        int[][] examinedRightDiagonals = new int[len][len];

        for (int y = 0; y < len; y++)
            for (int x = 0; x < len; x++) {
                if (board.getBoard()[y][x] == board.getLastPlayed()) {
                    int[] counts = new int[5];
                    if (examinedHorizontal[y][x] == 0)
                        counts[1] = countHorizontal(board, y, x, examinedHorizontal);
                    if (examinedVertical[y][x] == 0)
                        counts[2] = countVertical(board, y, x, examinedVertical);
                    if (examinedLeftDiagonals[y][x] == 0)
                        counts[3] = countLeftDiagonal(board, y, x, examinedLeftDiagonals);
                    if (examinedRightDiagonals[y][x] == 0)
                        counts[4] = countRightDiagonal(board, y, x, examinedRightDiagonals);
                    for (int i = 0; i < counts.length; i++) {
                        if (counts[i] == 4)
                            this.fourInRow++;
                        if (counts[i] == 3)
                            this.threeInRow++;
                        if (counts[i] == 2)
                            this.twoInRow++;
                    }
                }
            }
        /*System.out.println("Four in row: " + fourInRow + " Three in row: " + threeInRow + " broken three: " + brokenThrees + " Two in row " + twoInRow);
        System.out.println("Horizontal");
        TerminalGame.printBoard(examinedHorizontal);
        System.out.println("Vertical");
        TerminalGame.printBoard(examinedVertical);
        System.out.println("LeftDiagonals");
        TerminalGame.printBoard(examinedLeftDiagonals);
        System.out.println("RightDiagonals");
        TerminalGame.printBoard(examinedRightDiagonals);*/
    }


    private int countHorizontal(Board board, int y, int x, int[][] record) {
        int tempX = x;
        int count = 1;
        int len = board.getBoard().length;
        record[y][x] = 1;
        int blocked = 0;

        while (tempX > 0 && board.getBoard()[y][tempX - 1] == board.getLastPlayed()) {
            count++;
            tempX--;
            record[y][tempX] = 1;
        }
        if (tempX == 0 || (tempX > 0 && board.getBoard()[y][tempX - 1] != 0))
            blocked++;
        tempX = x;
        while (tempX < (len - 1) && board.getBoard()[y][tempX + 1] == board.getLastPlayed()) {
            count++;
            tempX++;
            record[y][tempX] = 1;
        }
        if (tempX == (len - 1) || (tempX < (len - 1) && board.getBoard()[y][tempX + 1] != 0))
            blocked++;
        if (blocked == 2)
            return 0;
        return count;
    }

    private int countVertical(Board board, int y, int x, int[][] record) {
        int tempY = y;
        int count = 1;
        int len = board.getBoard().length;
        record[y][x] = 1;
        int blocked = 0;

        while (tempY > 0 && board.getBoard()[tempY - 1][x] == board.getLastPlayed()) {
            count++;
            tempY--;
            record[tempY][x] = 1;
        }
        if (tempY == 0 || (tempY > 0 && board.getBoard()[tempY - 1][x] != 0))
            blocked++;
        tempY = y;
        while (tempY < (len - 1) && board.getBoard()[tempY + 1][x] == board.getLastPlayed()) {
            count++;
            tempY++;
            record[tempY][x] = 1;
        }
        if (tempY == (len - 1) || (tempY < (len - 1) && board.getBoard()[tempY + 1][x] != 0))
            blocked++;
        if (blocked == 2)
            return 0;
        return count;
    }

    private int countLeftDiagonal(Board board, int y, int x, int[][] record) {
        int tempY = y;
        int tempX = x;
        int count = 1;
        int len = board.getBoard().length;
        record[y][x] = 1;
        int blocked = 0;

        while (tempY > 0 && tempX > 0 && board.getBoard()[tempY - 1][tempX - 1] == board.getLastPlayed()) {
            count++;
            tempY--;
            tempX--;
            record[tempY][tempX] = 1;
        }
        if (tempY == 0 || tempX == 0 || (tempY > 0 && tempX > 0 && board.getBoard()[tempY - 1][tempX - 1] != 0))
            blocked++;
        tempY = y;
        tempX = x;
        while (tempY < len - 1 && tempX < len - 1 && board.getBoard()[tempY + 1][tempX + 1] == board.getLastPlayed()) {
            count++;
            tempY++;
            tempX++;
            record[tempY][tempX] = 1;
        }
        if (tempY == (len - 1) || tempX == (len - 1) || (tempY < (len - 1) && tempX < (len - 1) && board.getBoard()[tempY + 1][tempX + 1] != 0))
            blocked++;
        if (blocked == 2)
            return 0;
        return count;
    }


    private int countRightDiagonal(Board board, int y, int x, int[][] record) {
        int tempY = y;
        int tempX = x;
        int count = 1;
        int len = board.getBoard().length;
        record[y][x] = 1;
        int blocked = 0;

        while (tempY > 0 && tempX < len - 1 && board.getBoard()[tempY - 1][tempX + 1] == board.getLastPlayed()) {
            count++;
            tempY--;
            tempX++;
            record[tempY][tempX] = 1;
        }
        if (tempY == 0 || tempX == len - 1 || (tempY > 0 && tempX < len - 1 && board.getBoard()[tempY - 1][tempX + 1] != 0))
            blocked++;
        tempY = y;
        tempX = x;
        while (tempY < len -1 && tempX > 0 && board.getBoard()[tempY + 1][tempX - 1] == board.getLastPlayed()) {
            count++;
            tempY++;
            tempX--;
            record[tempY][tempX] = 1;
        }
        if (tempY == (len - 1) || tempX == 0 || (tempY < (len - 1) && tempX > 0 && board.getBoard()[tempY + 1][tempX - 1] != 0))
            blocked++;
        if (blocked == 2)
            return 0;
        return count;
    }

}