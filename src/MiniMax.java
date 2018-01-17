import java.util.ArrayList;

public class MiniMax {
    public static int miniMax(Board board, int depth, boolean max, int p, int alpha, int beta){
        int bestValue;
        int l;
        int i = 0;
        int value;
        ArrayList<Board> nodes;

        if (depth == 0) {
            Move t = BoardHeuristic.heuristicSum(board, board.getBoard(), p);
            return (t.piece);
        }
        if (max){
            if (board.isTerminal())
                return (2500);
            bestValue = -10000;
            nodes = ExpandBoard.expand(board);
            l = nodes.size();
            while (i < l){
                value = miniMax(nodes.get(i), depth - 1, false, (p % 2) + 1, alpha, beta);
                bestValue = Math.max(bestValue, value);
                alpha = Math.max(alpha, bestValue);
                if (beta <= alpha)
                    break;
                i++;
            }
            return (bestValue);
        }
        else {
            if (board.isTerminal())
                return (2400);
            bestValue = 10000;
            nodes = ExpandBoard.expand(board);
            l = nodes.size();
            while (i < l){
                value = miniMax(nodes.get(i), depth - 1, true, (p % 2) + 1, alpha, beta);
                bestValue = Math.min(bestValue, value);
                beta = Math.min(beta, bestValue);
                if (beta <= alpha)
                    break;
                i++;
            }
            return (bestValue);
        }
    }
}
