import java.util.ArrayList;

public class PreBoardHeuristic {

    public static Move BoardAi(Board board, Player player){

        /*Move tp = BoardHeuristic.heuristicSum(board, board.getBoard(), player.getName());
        if (tp.piece >= 1700) {
            System.out.println("move r" + tp.y + " c " + tp.x);
            tp.piece = player.getName();
            return (tp);
        }
        ArrayList<Board> nodes = ExpandBoard.expand(board);
        int l = nodes.size();
        if (l == 0)
            return (new Move(9, 9, player.getName()));
        for (int i = 0; i < l; i++) {
            nodes.get(i).setHeuristic(MiniMax.miniMax(nodes.get(i), 3, false, player.getName(), -10000, 10000, player));
        }*/
        ArrayList<Board> nodes = ExpandBoard.expand(board);
        int l = nodes.size();
        if (l == 0)
            return (new Move(9, 9, player.getName()));

        Threading thread1 = new Threading("Thread 1", nodes, 1, player);
        thread1.start();
        Threading thread2 = new Threading("Thread 2", nodes, 2, player);
        thread2.start();
        Threading thread3 = new Threading("Thread 3", nodes, 3, player);
        thread3.start();
        Threading thread4 = new Threading("Thread 4", nodes, 4, player);
        thread4.start();
        /*try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }
        catch (InterruptedException e){
            System.out.println("Error joining");
        }*/
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
