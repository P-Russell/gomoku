import java.util.Arrays;

public class Board extends Capture {
    private int[][] board = new int[19][19];
    private int lastPlayed = 2;
    private int lastX;
    private int lastY;
    private boolean gameOver = false;
    private ValidMove valid = new ValidMove();

    public boolean placeStone(int x, int y){

        if (x < 19 && x >= 0 && y < 19 && y >= 0 && board[y][x] == 0){
            if (lastPlayed == 1 && !valid.doubleThree(board, y, x,2)) {
                    board[y][x] = lastPlayed = 2;
                }
            else if (!valid.doubleThree(board, y, x, 1)) {
                    board[y][x] = lastPlayed = 1;
                }
            else
                return false;
            if (capture(board, y, x, lastPlayed))
                System.out.println("Capture");
            lastX = x;
            lastY = y;
            return true;
        }
        System.out.println("Invalid move");
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

    public boolean getGameOver(){
        if (this.gameOver)
            return this.gameOver;
        this.gameOver = valid.isWinMove(this);
        return this.gameOver;
    }

    public void setGameOver(boolean bool){
        this.gameOver = bool;
    }

    public int[][] getBoard() {
        return board;
    }

    public void printBoard(){
        for(int i = 0; i < 19; i++)
            System.out.println(Arrays.toString(board[i]));
    }
}
