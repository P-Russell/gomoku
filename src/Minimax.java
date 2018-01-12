import java.util.LinkedList;
import java.util.List;

public class Minimax {

    private int r = 0;
    private int l = 19;
    private int u = 19;
    private int d = 0;
    private ValidMove dt = new ValidMove();
    private Heuristic hr = new Heuristic();
    private Board b = new Board();


    public int[] options(int[][] brd, int p){
        int[][] curBrd;
        int[] t;
        int[][] brdSol = new int[19][19];
        int[][] temp;
        curBrd = hr.heuristic(brd, p);
        t = best_coord(curBrd);
        //winning move or block winning move
        if (t[2] >= 1900)
            return (t);
        temp = brd;
        int i = u;
        while (i <= d){
            int j = l;
            while (j <= r){
                if (temp[i][j] == 0 && !dt.doubleThree(temp, i, j, p)){
                    temp[i][j] = p;
                    brdSol[i][j] = miniMax(temp, 5, false, -10000, 10000, p);
                    temp[i][j] = 0;
                }
                j++;
            }
            i++;
        }
        return (best_coord(brdSol));
    }


    private int[] best_coord(int[][] brd){
        int[] cor = new int[3];
        int i = u;
        int row = 0;
        int col = 0;
        int val = 0;
        while (i <= d){
            int j = l;
            while (j <= r){
                if (brd[i][j] > val) {
                    row = i;
                    col = j;
                    val = brd[i][j];
                }
                j++;
            }
            i++;
        }
        cor[0] = row;
        cor[1] = col;
        cor[2] = val;
        return (cor);
    }

    private int miniMax(int[][] brd, int depth, boolean max, int alpha, int beta, int player){
        int p;
        int l;
        int i;
        List temp;
        if (depth == 0)
            return (hr.heuristicSum(brd, player));
        if (max){
            p = (player % 2) + 1;
            int bestVal = -10000;
            temp = child(brd, player);
            l = temp.size();
            i = 0;
            while (i < l){
                //winning move
                if (winGame((int[][])temp.get(i)))
                    return (2000);
                int value = miniMax((int[][])temp.get(i), (depth - 1), false, alpha, beta, p);
                bestVal = Math.max(value, bestVal);
                alpha = Math.max(alpha, bestVal);
                if (beta <= alpha)
                    break;
                i++;
            }
            return (bestVal);
        }
        else {
            p = (player % 2) + 1;
            int bestVal = 10000;
            temp = child(brd, player);
            l = temp.size();
            i = 0;
            //goes through all the available moves
            while (i < l){
                //winning move
                if (winGame((int[][]) temp.get(i)))
                    return (-2000);
                int value = miniMax((int[][])temp.get(i), (depth - 1), true, alpha, beta, p);
                bestVal = Math.min(value, bestVal);
                beta = Math.min(alpha, bestVal);
                if (beta <= alpha)
                    break;
                i++;
            }
            return (bestVal);
        }
    }

    //gets all available moves
    private List child(int[][] brd, int p){
        int i = 0;
        r = 0;
        d = 0;
        l = 19;
        u = 19;
        while (i < 19){
            int j = 0;
            while (j < 19){
                if (brd[i][j] != 0){
                    r = Math.max(r, j);
                    d = Math.max(d, i);
                    l = Math.min(l, j);
                    u = Math.min(u, i);
                }
                j++;
            }
            i++;
        }
        r = (r + 3 > 18) ? 18 : r + 3;
        d = (d + 3 > 18) ? 18 : d + 3;
        u = (u - 3 > 18) ? 0 : u - 3;
        l = (l - 3 > 18) ? 0 : l - 3;
        return (boardHeuristic(brd, p));
    }


    //need to check if move is valid
    private List boardHeuristic(int[][] brd, int p){
        LinkedList<int[][]> g = new LinkedList<>();
        int[][] t;
        int i = u;
        while (i <= d) {
            int j = l;
            while (j <= r) {
                t = brd;
                if (t[i][j] == 0 && !dt.doubleThree(t, i, j, p)) {
                    t[i][j] = p;
                    g.add(t);
                }
                j++;
            }
            i++;
        }
        return (g);
    }

    private boolean winGame(int[][] brd){
        b.board = brd;
        if (dt.countHorizontal(b) == 5 || dt.countVertical(b) == 5 || dt.countDiagonals(b) == 5)
            return (true);
        return (false);
    }

}
