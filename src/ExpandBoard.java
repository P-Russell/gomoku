import java.util.ArrayList;

public class ExpandBoard {


    public static ArrayList<Board> expand(Board board) {
        ArrayList<Board> expanded = new ArrayList<>();
        int[][] moves = new int[board.getBoard().length][board.getBoard().length];
        CheckMove validator = new CheckMove();
        int stepFromPlaced = 2;
        for(int y = 0; y < board.getBoard().length; y++)
            for(int x = 0; x < board.getBoard().length; x++) {
                if (board.getBoard()[y][x] != board.getLastPlayed()) {
                    for(int i = stepFromPlaced; i > 0; i--)
                        if(!(i + x > board.getBoard().length) && moves) {

                        }










                    Board node = new Board(board);
                    if (validator.isCaptureMove(node, y, x)) {
                        validator.capturePieces(node, y, x);
                        node.placeValidatedPiece(y, x);
                        expanded.add(node);
                    }
                    else if (!validator.isDoubleThree(node, y, x)) {
                        node.placeValidatedPiece(y, x);
                        expanded.add(node);
                    }
                }
            }
        return expanded;
    }
}
