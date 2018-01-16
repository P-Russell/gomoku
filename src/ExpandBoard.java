import java.util.ArrayList;

public class ExpandBoard {


    public static ArrayList<Board> expand(Board board) {
        ArrayList<Board> expanded = new ArrayList<Board>();
        CheckMove validator = new CheckMove();
        for(int y = 0; y < board.getBoard().length; y++)
            for(int x = 0; x < board.getBoard().length; x++) {
                if (board.getBoard()[y][x] == 0) {
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


//    private ArrayList<Move> createOptions(Board board) {
//        ArrayList<Move> moves = new ArrayList<Move>();
//        CheckMove validator = new CheckMove()
//        for(int y = 0; y < board.getBoard().length; y++)
//            for(int x = 0; x < board.getBoard().length; x++) {
//                if (board.getBoard()[y][x] == 0) {
//                    Board node = new Board(board);
//                    if (validator.isCaptureMove(node, y, x)) {
//                        validator.capturePieces(node, y, x);
//                        node.placeValidatedPiece(y, x);
//                    }
//                    else if (!validator.isDoubleThree(node, y, x)) {
//                        node.placeValidatedPiece(y, x);
//                    }
//
//                }
//            }
//        return moves;
//    }

}
