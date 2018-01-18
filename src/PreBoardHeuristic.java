import java.util.ArrayList;

public class PreBoardHeuristic {

    public static Move BoardAi(Board board, Player player){

        Move tp = BoardHeuristic.heuristicSum(board, board.getBoard(), player.getName());
        if (tp.piece >= 1800) {
            System.out.println("move r" + tp.y + " c " + tp.x);
            tp.piece = player.getName();
            return (tp);
        }
        ArrayList<Board> nodes = ExpandBoard.expand(board);
        int l = nodes.size();
        if (l == 0)
            return (new Move(9, 9, player.getName()));
        for (int i = 0; i < l; i++) {
            nodes.get(i).setHeuristic(MiniMax.miniMax(nodes.get(i), 2, false, player.getName(), -10000, 10000, player));
        }
        int val = 0;
        int t = 0;
        for (int i = 0; i < l; i++) {
            if (val <= nodes.get(i).getHeuristic()) {
                if (val < nodes.get(i).getHeuristic()) {
                    val = nodes.get(i).getHeuristic();
                    t = i;
                }
                else if (((board.getLastY() - nodes.get(t).getLastY()) ^ 2) + ((board.getLastX() - nodes.get(t).getLastX()) ^ 2) >
                        ((board.getLastY() - nodes.get(i).getLastY()) ^ 2) + ((board.getLastX() - nodes.get(i).getLastX()) ^ 2)){
                    t = i;
                }
            }
        }
            /*Move t = BoardHeuristic.heuristicSum(board, board.getBoard(), this.getName());
            if (t.piece >= 1400) {
                t.piece = this.getName();
                return (t);
            }*/
        //MiniMax.miniMax(board, 5, true, this.getName());
        return (new Move(nodes.get(t).getLastY(), nodes.get(t).getLastX(), player.getName()));

    }
}
