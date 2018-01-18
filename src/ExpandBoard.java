import java.util.ArrayList;

public class ExpandBoard {


    public static ArrayList<Board> expand(Board board) {
        ArrayList<Board> expanded = new ArrayList<>();
        int[][] moves = new int[board.getBoard().length][board.getBoard().length];
        CheckMove validator = new CheckMove();
        int stepFromPlaced = 2;


        for (int y = 0; y < board.getBoard().length; y++)
            for (int x = 0; x < board.getBoard().length; x++) {





                if (board.getBoard()[y][x] != 0) {



                    for (int tempY = y - stepFromPlaced;
                         tempY <= (y + stepFromPlaced) && tempY < board.getBoard().length; tempY++)
                        for (int tempX = x - stepFromPlaced;
                             tempX <= (x + stepFromPlaced) && tempX < board.getBoard().length; tempX++) {



                            if (tempX >= 0 && tempY >= 0 && moves[tempY][tempX] == 0 && board.getBoard()[tempY][tempX] == 0) {


                                moves[tempY][tempX] = 1;
                                Board node = new Board(board);
                                if (validator.isCaptureMove(node, tempY, tempX)) {
                                    validator.capturePieces(node, tempY, tempY);
                                    node.placeValidatedPiece(tempY, tempX);
                                    expanded.add(node);
                                } else if (!validator.isDoubleThree(node, tempY, tempX)) {
                                    node.placeValidatedPiece(tempY, tempX);
                                    expanded.add(node);
                                }

                            }
                        }
                }
            }
        return expanded;
    }
}