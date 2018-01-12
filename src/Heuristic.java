public class Heuristic {

    //heuristic of each individual position
    //to be used before miniMax is called
    int[][] heuristic(int[][] brd, int p){
        int[] limits = brdLimits(brd);
        int[][] brdSol = new int[19][19];
        int i = limits[0];
        while (i <= limits[3]){
            int j = limits[1];
            while (j <= limits[2]){
                if (brd[i][j] == 0) {
                    int pl = 500 * row(brd, p, i, j);
                    int op = (500 * row(brd, ((p % 2) + 1), i, j)) - 100 ;
                    brdSol[i][j] = Math.max(pl, op);
                }
                j++;
            }
            i++;
        }
        return (brdSol);
    }

    //heuristic of whole board i.e the heuristic
    //sent back by the miniMax nodes
    //it doesn't have to be the sum
    int heuristicSum(int[][] brd, int p){
        int[] limits = brdLimits(brd);
        int[][] brdSol = heuristic(brd, p);
        int i = limits[0];
        int val = 0;
        while (i <= limits[3]){
            int j = limits[1];
            while (j <= limits[2]){
                if (brdSol[i][j] != 0 && val < brdSol[i][j])
                    val = brdSol[i][j];
                j++;
            }
            i++;
        }
        //currently returns the max value over the whole board
        return (val);
    }


    private int vertical(int[][] brd, int p, int r, int c, int dir){
        int i = 0;
        int countA = 0;
        while (i < 4){
            if (r + 4 * dir  <= 18 && r + 4 * dir >= 0 && brd[r + dir + i * dir][c] != (p % 2) + 1) {
                if (brd[r + dir + i * dir][c] == p)
                    countA++;
            }
            else
                return (0);
            i++;
        }
        return (countA);
    }

    private int horizontal(int[][] brd, int p, int r, int c, int dir){
        int countA = 0;
        int i = 0;
        while (i < 4){
            if (c + 4 * dir <= 18 && c + 4 * dir >= 0 && brd[r][c + dir + i * dir] != (p % 2) + 1) {
                if (brd[r][c + dir + i * dir] == p)
                    countA++;
            }
            else
                break;
            i++;
        }
        return (countA);
    }

    private int diagonalRight(int[][] brd, int p, int r, int c, int dir){
        int countA = 0;
        int i = 0;
        while (i < 4){
            if (c + 4 * dir <= 18 && r + 4 * dir <= 18 && c + 4 * dir >= 0 && brd[r + 1 + i][c + dir + i * dir] != (p % 2) + 1) {
                if (brd[r + 1 + i][c + dir + i * dir] == p)
                    countA++;
            }
            else
                break;
            i++;
        }
        return (countA);
    }

    private int diagonalLeft(int[][] brd, int p, int r, int c, int dir){
        int countA = 0;
        int i = 0;
        while (i < 4){
            if (c + 4 * dir <= 18 && r + 4 * dir <= 18 && r + 4 * dir >= 0 && brd[r + dir + i * dir][c + 1 + i] != (p % 2) + 1) {
                if (brd[r + dir + i * dir][c + 1 + i] == p)
                    countA++;
            }
            else
                break;
            i++;
        }
        return (countA);
    }

    private int row(int[][] brd, int p, int r, int c){
        //vertical up and down
        int val = vertical(brd, p, r, c, 1);
        val = Math.max(val, vertical(brd, p, r, c, -1));
        //horizontal right and left
        val = Math.max(val, horizontal(brd, p, r, c, 1));
        val = Math.max(val, horizontal(brd, p, r, c, -1));
        //diagonal Right up and down
        val = Math.max(val, diagonalRight(brd, p, r, c, -1));
        val = Math.max(val, diagonalRight(brd, p, r, c, 1));
        //diagonal left up and down
        val = Math.max(val, diagonalLeft(brd, p, r, c, -1));
        val = Math.max(val, diagonalLeft(brd, p, r, c, 1));
        return (val);
    }

    private int[] brdLimits(int[][] brd){
        int[] limits = new int[4];
        limits[0] = 19;//upper
        limits[1] = 19;//left
        limits[2] = 0;//lower
        limits[3] = 0;//right
        int i = 0;
        while (i < 19){
            int j = 0;
            while (j < 19){
                if (brd[i][j] != 0){
                    limits[0] = Math.min(limits[0], i);//upper
                    limits[1] = Math.min(limits[1], j);//left
                    limits[2] = Math.max(limits[2], i);//right
                    limits[3] = Math.max(limits[3], j);//lower
                }
                j++;
            }
            i++;
        }
        return (limits);
    }
}
