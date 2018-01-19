public class Board
{
    private int[][] board;
    private int lastPlayed;
    private int lastX;
    private int lastY;
    public Board parent;
    public int generation;

    public Board(Board board) {
        this.board = new int[board.getBoard().length][];
        for(int i = 0; i < board.getBoard().length; i++)
            this.board[i] = board.getBoard()[i].clone();
        this.lastY = board.getLastY();
        this.lastX = board.getLastX();
        this.lastPlayed = board.getLastPlayed();
        this.parent = board;
        this.generation = board.generation + 1;
    }

    public Board(int dimensions){
        this.board = new int[dimensions][dimensions];
        this.lastPlayed = 2;
        this.generation = 0;
    }

    //Debugging code
    public Board(int[][] board, int lastPlayed, int lastX, int lastY) {
        this.board = board;
        this.lastPlayed = lastPlayed;
        this.lastX = lastX;
        this.lastY = lastY;
    }

    public void placeValidatedPiece(int y, int x) {
        if (this.lastPlayed == 1)
            this.board[y][x] = this.lastPlayed = 2;
        else
            this.board[y][x] = this.lastPlayed = 1;
        this.lastX = x;
        this.lastY = y;
    }

    public void placeSuggestedPiece(int y, int x, int val){
        this.board[y][x] = val;
    }

    public boolean isTerminal() {
        WinningMove winMove = new WinningMove();
        return winMove.isWinMove(this);
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

    public int[][] getBoard() {
        return board;
    }
}
