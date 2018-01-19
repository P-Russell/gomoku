import java.util.ArrayList;

//function minimax(node, depth, isMaximizingPlayer, alpha, beta):
//
//    if node is a leaf node :
//        return value of the node
//
//    if isMaximizingPlayer :
//        bestVal = -INFINITY
//        for each child node :
//            value = minimax(node, depth+1, false, alpha, beta)
//            bestVal = max( bestVal, value)
//            alpha = max( alpha, bestVal)
//            if beta <= alpha:
//                break
//        return bestVal
//
//    else :
//        bestVal = +INFINITY
//        for each child node :
//            value = minimax(node, depth+1, true, alpha, beta)
//            bestVal = min( bestVal, value)
//            beta = min( beta, bestVal)
//            if beta <= alpha:
//                break
//        return bestVal





public class MinMax {

    private static Board bestBoard(Board board1, Board board2) {
        int h1 = Heuristic.boardValue(board1);
        int h2 = Heuristic.boardValue(board2);
        if (h1 > h2)
            return board1;
        else
            return board2;
    }

    private static Board worstBoard(Board board1, Board board2) {
        int h1 = Heuristic.boardValue(board1);
        int h2 = Heuristic.boardValue(board2);
        if (h1 > h2)
            return board2;
        else
            return board1;
    }
/*    if node is a leaf node :
        return value of the node

    if isMaximizingPlayer :
        bestVal = -INFINITY
        for each child node :
            value = minimax(node, depth+1, false, alpha, beta)
            bestVal = max( bestVal, value)
            alpha = max( alpha, bestVal)
            if beta <= alpha:
                break
        return bestVal

    else :
        bestVal = +INFINITY
        for each child node :
            value = minimax(node, depth+1, true, alpha, beta)
            bestVal = min( bestVal, value)
            beta = min( beta, bestVal)
            if beta <= alpha:
                break
        return bestVal */
    public static Board miniMax(Board node, int depth, boolean isMaximizer) {
        if (node.isTerminal() || depth == 0) {
            //TerminalGame.printBoard(node.getBoard());
            return node;
        }

        if (isMaximizer) {
            Board bestBoard = new Board(node.getBoard().length);
            ArrayList<Board> children = ExpandBoard.expand(node);
            for (int i = 0; i < children.size(); i++) {
                if (i == 0)
                    bestBoard = miniMax(children.get(i), depth - 1, false);
                else {
                    Board value = miniMax(children.get(i), depth - 1, false);
                    bestBoard = bestBoard(value, bestBoard);
                }
            }
            return bestBoard;
        }
        else {
            Board worstBoard = new Board(node.getBoard().length);
            ArrayList<Board> children = ExpandBoard.expand(node);
            for (int i = 0; i < children.size(); i++) {
                if (i == 0)
                    worstBoard = miniMax(children.get(i), depth - 1, true);
                else {
                    Board value = miniMax(children.get(i), depth - 1, true);
                    worstBoard = worstBoard(value, worstBoard);
                }
            }
            return worstBoard;
        }

    }

    public static Move bestMove(Board board) {
        Board bestBoard = miniMax(board, 4, true);
        TerminalGame.printBoard(bestBoard.getBoard());
//        System.out.println("Returned Board");
//        TerminalGame.printBoard(test.getBoard());
//        ArrayList<Board> search = ExpandBoard.expand(board);
//        Board test = new Board(board.getBoard().length);
//        Board bestBoard = new Board(board.getBoard().length);
//        int bestValue = 0;
//        int utility;
//        System.out.println("search space: " + search.size());
//        for(int i = 0; i < search.size(); i++) {
//            test = search.get(i);
//            utility = Heuristic.boardValue(test);
//            bestBoard = bestBoard(test, bestBoard);
//
//        }
//        System.out.println("Best board found");
//        TerminalGame.printBoard(bestBoard.getBoard());
        while(bestBoard.generation > 1)
            bestBoard = bestBoard.parent;
        Move move = new Move(bestBoard.getLastY(), bestBoard.getLastX(), bestBoard.getLastPlayed());
        System.out.println("Best Move x: " + move.x + " y " + move.y);
        return move;
    }

}