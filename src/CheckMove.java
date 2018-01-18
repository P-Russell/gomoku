public class CheckMove {

    private boolean isEmptyAndInRange(int[][] board, int y, int x) {
        if (y < board.length && x < board.length && board[y][x] == 0)
            return true;
        return false;
    }

    public boolean isWinningMove(Board board) {
        WinningMove winMove = new WinningMove();
        return winMove.isWinMove(board);
    }

    public boolean isDoubleThree(Board board, int y, int x) {
        if (!isEmptyAndInRange(board.getBoard(), y, x))
            return true;
        DoubleThree checkDoubleThree = new DoubleThree();
        if (board.getLastPlayed() == 1)
            return checkDoubleThree.doubleThree(board.getBoard(), y, x, 2);
        else
            return checkDoubleThree.doubleThree(board.getBoard(), y, x, 1);
    }

    public boolean isCaptureMove(Board board, int y, int x) {
        if (!isEmptyAndInRange(board.getBoard(), y, x))
            return false;
        Capture validCapture = new Capture();
        if (board.getLastPlayed() == 1)
            return validCapture.isCaptureMove(board.getBoard(), y, x, 2);
        else
            return validCapture.isCaptureMove(board.getBoard(), y, x, 1);
    }

    public boolean capturePieces(Board board, int y, int x) {
        if (!isEmptyAndInRange(board.getBoard(), y, x))
            return false;
        Capture validCapture = new Capture();
        if (board.getLastPlayed() == 1)
            return validCapture.capturePieces(board.getBoard(), y, x, 2);
        else
            return validCapture.capturePieces(board.getBoard(), y, x, 1);
    }

    public boolean validateAndCapturePieces(Board board, int y, int x) {
        if (capturePieces(board, y, x)) {
            return true;
        }
        else if (isDoubleThree(board, y, x)) {
            return false;
        }
        return true;
    }

    public boolean singleThree(Board board, int y, int x){
        DoubleThree d = new DoubleThree();
        if (board.getLastPlayed() == 1)
            return (d.Three(board.getBoard(), y, x, 2));
        else
            return (d.Three(board.getBoard(), y, x, 1));
    }

}
