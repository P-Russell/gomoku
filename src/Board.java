public class Board
{
    private int[][] board = new int[19][19];
    private int lastPlayed;
    private int lastX;
    private int lastY;

    //function assumes that the proposed move has been checked for validity

    public Board(int[][] board) {
        this.board = new int[board.length][];
        for(int i = 0; i < board.length; i++)
            this.board[i] = board[i].clone();
    }

    public boolean placePiece(int x, int y, int piece) {
        if (x < 19 && x >= 0 && y < 19 && y >= 0 && board[y][x] == 0) {
            if (lastPlayed == 1)
                board[y][x] = lastPlayed = 2;
            else
                board[y][x] = lastPlayed = 1;
            lastX = x;
            lastY = y;
            return true;
        }
        return false;
    }

    public int getLastPlayed() {
        return lastPlayed;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }
}
