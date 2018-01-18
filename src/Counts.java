public class Counts {
    public int fourInRow;
    public int threeInRow;
    public int brokenThrees;
    public int twoInRow;

    public Counts(Board board) {
        init(this, board);
    }

    private void init(Counts count, Board board) {
        int len = board.getBoard().length;
        int[][] examinedHorizontal = new int[len][len];
        int[][] examinedVertical = new int[len][len];
        int[][] examinedLeftDiagonals = new int[len][len];
        int[][] examinedRightDiagonals = new int[len][len];
        int horizontalCount;
        int verticalCount;
        int leftDiagonalsCount;
        int rightDiagonalsCount;

        for (int y = 0; y < len; y++)
            for (int x = 0; x < len; x++) {
                if (board.getBoard()[y][x] == board.getLastPlayed()) {
                    if (examinedHorizontal[y][x] == 0)
                        horizontalCount = countHorizontal(board, y, x, examinedHorizontal);
                    if (examinedVertical[y][x] == 0)
                        verticalCount = countVertical(board, y, x, examinedVertical);
                   /* if (examinedLeftDiagonals[y][x] == 0)
                        leftDiagonalsCount = countLeftDiagonals(board, y, x, examinedLeftDiagonals);
                    if (examinedRightDiagonals[y][x] == 0)
                        rightDiagonalsCount = countRightDiagonals(board, y, x, examinedRightDiagonals);*/
                }
            }
    }


    private int countHorizontal(Board board, int y, int x, int[][] record){
        int tempX = x;
        int count = 1;
        int len = board.getBoard().length;
        record[y][x] = 1;
        int blocked = 0;

        while (tempX > 0 && board.getBoard()[y][tempX - 1] == board.getLastPlayed()){
            count++;
            tempX--;
            record[y][tempX] = 1;
        }
        if(tempX == 0 || (tempX > 0 && board.getBoard()[y][tempX - 1] != 0))
            blocked++;
        tempX = x;
        while (tempX < 18 && board.getBoard()[y][tempX + 1] == board.getLastPlayed()){
            count++;
            tempX++;
            record[y][tempX] = 1;
        }
        if(tempX == (len - 1) || (tempX < (len -1) && board.getBoard()[y][tempX + 1] != 0))
            blocked++;
        if (blocked == 2)
            return 0;
        return count;
    }


    private int countVertical(Board board, int y, int x, int[][] record){
        int lastX = board.getLastX();
        int tempY = board.getLastY();
        int count = 1;

        while (tempY > 0 && board.getBoard()[tempY - 1][lastX] == board.getLastPlayed()){
            count++;
            tempY--;
        }
        tempY = board.getLastY();
        while (tempY < 18 && board.getBoard()[tempY + 1][lastX] == board.getLastPlayed()){
            count++;
            tempY++;
        }
        return count;
    }


    private int countDiagonals(Board board, int y, int x, int[][] record){
        int tempY = board.getLastY();
        int tempX = board.getLastX();
        int count = 1;

        while (tempX > 0 && tempY > 0 && board.getBoard()[tempY - 1][tempX - 1] == board.getLastPlayed()){
            tempX--;
            tempY--;
            count++;
        }
        tempX = board.getLastX();
        tempY = board.getLastY();
        while (tempX < 18 && tempY < 18 && board.getBoard()[tempY + 1][tempX + 1] == board.getLastPlayed()){
            tempX++;
            tempY++;
            count++;
        }
        if (count == 5)
            return count;
        count = 1;
        tempX = board.getLastX();
        tempY = board.getLastY();
        while (tempX < 18 && tempY > 0 && board.getBoard()[tempY - 1][tempX + 1] == board.getLastPlayed()){
            tempX++;
            tempY--;
            count++;
        }
        tempX = board.getLastX();
        tempY = board.getLastY();
        while (tempX > 0 && tempY < 18 && board.getBoard()[tempY + 1][tempX - 1] == board.getLastPlayed()){
            tempX--;
            tempY++;
            count++;
        }
        return count;
    }
}