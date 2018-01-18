public class Board
{
    private int[][] board;
    private int lastPlayed;
    private int lastX;
    private int lastY;
    private int heuristic;
    private Move upLeft = new Move(19, 19, 0);
    private Move downRight = new Move(0, 0, 0);

    public Board(Board board) {
        this.board = new int[board.getBoard().length][];
        for(int i = 0; i < board.getBoard().length; i++)
            this.board[i] = board.getBoard()[i].clone();
        this.lastY = board.getLastY();
        this.lastX = board.getLastX();
        this.lastPlayed = board.getLastPlayed();
        this.upLeft = board.getUpLeft();
        this.downRight = board.getDownRight();
    }

    public Board(int dimensions){
        this.board = new int[dimensions][dimensions];
        this.lastPlayed = 2;
    }

    public void placeValidatedPiece(int y, int x) {
        if (this.lastPlayed == 1)
            this.board[y][x] = this.lastPlayed = 2;
        else
            this.board[y][x] = this.lastPlayed = 1;
        this.lastX = x;
        this.lastY = y;
        //upLeft
        if (y < this.upLeft.y)
            this.upLeft.y = y;
        if (x < this.upLeft.x)
            this.upLeft.x = x;
        //downRight
        if (y > this.downRight.y)
            this.downRight.y = y;
        if (x > this.downRight.x)
            this.downRight.x = x;
    }

    public void placeSuggestedPiece(int y, int x, int val){
        this.board[y][x] = val;
    }

    public boolean isTerminal() {
        WinningMove winMove = new WinningMove();
        return winMove.isWinMove(this);
    }

    public Move getUpLeft(){
        return (this.upLeft);
    }

    public Move getDownRight() {
        return (this.downRight);
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

    public void setHeuristic(int v){
        this.heuristic = v;
    }

    public int getHeuristic(){
        return this.heuristic;
    }
}
