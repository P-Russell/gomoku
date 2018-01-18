import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private int name;
    private int score;
    private boolean isAI;

    public Player(int name) {
        this.name = name;
        this.score = 0;
        this.isAI = setAI();
    }

    public Player(int name, boolean isAI){
        this.name = name;
        this.score = 0;
        this.isAI = isAI;
    }

    private boolean setAI() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Set player " + this.name + " to Human? - yes/no");
            String line = s.nextLine();
            if (line.trim().toLowerCase().equals("yes"))
                return false;
            else if (line.trim().toLowerCase().equals("no"))
                return true;
            else
                System.out.println("invalid selection");
        }
    }

    public Move getBestMove(Board board) {
        if (this.isAI) {
           /* Move tp = BoardHeuristic.heuristicSum(board, board.getBoard(), this.getName());
            System.out.println(tp.piece);
            if (tp.piece >= 1400) {
                System.out.println("move r" + tp.y + " c " + tp.x);
                tp.piece = this.getName();
                return (tp);
            }

            ArrayList<Board> nodes = ExpandBoard.expand(board);
            int l = nodes.size();
            for (int i = 0; i < l; i++) {
                nodes.get(i).setHeuristic(MiniMax.miniMax(nodes.get(i), 2, false, this.getName(), -10000, 10000));
            }
            int val = 0;
            int t = 0;
            for (int i = 0; i < l; i++) {
                if (val < nodes.get(i).getHeuristic()) {
                    val = nodes.get(i).getHeuristic();
                    t = i;
                }
            }*/
            Move t = BoardHeuristic.heuristicSum(board, board.getBoard(), this.getName());
            if (t.piece >= 1400) {
                t.piece = this.getName();
                return (t);
            }
            //MiniMax.miniMax(board, 5, true, this.getName());
            //return (new Move(nodes.get(t).getLastY(), nodes.get(t).getLastX(), this.getName()));
            return (TerminalGame.randomMove(board, this));
        } else
            return (TerminalGame.getMoveFromTerminal(board, this));
    }

    public int getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        this.score++;
    }

    public boolean isAI() {
        return isAI;
    }
}
