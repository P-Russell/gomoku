public class BoardHeuristic {

    public  static int[][] heuristic(Board board, int[][] brd, int p){
        int[] limits = brdLimits(brd);
        int[][] brdSol = new int[19][19];
        CheckMove valid = new CheckMove();
        int i = limits[0];
        while (i <= limits[3]){
            int j = limits[1];
            while (j <= limits[2]){
                if (brd[i][j] == 0 && (valid.isCaptureMove(board, i, j) || !valid.isDoubleThree(board, i, j))) {
                    int pl = 400 * row(brd, p, i, j, 4);
                    int op = (400 * row(brd, (p % 2) + 1, i, j, 4)) - 100;
                    int pl1 = 500 * row(brd, p, i, j, 3);
                    int op1 = (500 * row(brd, (p % 2) + 1, i, j, 3)) - 50;
                    pl = Math.max(pl, op);
                    pl1 = Math.max(pl1, op1);
                    brdSol[i][j] = pl + pl1;
                }
                else if (brd[i][j] != 0)
                    brdSol[i][j] = -1;
                j++;
            }
            i++;
        }
        return (brdSol);
    }

    //heuristic of whole board i.e the heuristic
    //sent back by the miniMax nodes
    //it doesn't have to be the sum
    public static Move heuristicSum(Board board, int[][] brd, int p){
        int[] limits = brdLimits(brd);
        int[][] brdSol = heuristic(board, brd, p);
        int i = limits[0];
        Move val = new Move(0, 0, 0);
        while (i <= limits[3]){
            int j = limits[1];
            while (j <= limits[2]){
                if (brdSol[i][j] != 0 && val.piece < brdSol[i][j]) {
                    val.piece = brdSol[i][j];
                    val.y = i;
                    val.x = j;
                }
                j++;
            }
            i++;
        }
        //TerminalGame.printBoard(brdSol);
        //currently returns the max value over the whole board
        return (val);
    }


    private static int vertical(int[][] brd, int p, int r, int c, int dir, int row){
        int i = 0;
        int countA = 0;
        while (i < row && r + row * dir  <= 18 && r + row * dir >= 0){
            if (brd[r + dir + i * dir][c] != (p % 2) + 1) {
                if (brd[r + dir + i * dir][c] == p)
                    countA++;
            }
            else if (brd[r + dir + i * dir][c] == (p % 2) + 1)
                return (0);
            i++;
        }
        return (countA);
    }

    private static int horizontal(int[][] brd, int p, int r, int c, int dir, int row){
        int countA = 0;
        int i = 0;
        while (i < row && c + row * dir <= 18 && c + row * dir >= 0){
            if (brd[r][c + dir + i * dir] != (p % 2) + 1) {
                if (brd[r][c + dir + i * dir] == p)
                    countA++;
            }
            else if (brd[r][c + dir + i * dir] == (p % 2) + 1)
                return (0);
            i++;
        }
        return (countA);
    }

    private static int diagonalRight(int[][] brd, int p, int r, int c, int dir, int row){
        int countA = 0;
        int i = 0;
        while (i < row && c + row * dir <= 18 && r + row <= 18 && c + row * dir >= 0){
            if (brd[r + 1 + i][c + dir + i * dir] != (p % 2) + 1) {
                if (brd[r + 1 + i][c + dir + i * dir] == p)
                    countA++;
            }
            else if (brd[r + 1 + i][c + dir + i * dir] == (p % 2) + 1)
                return (0);
            i++;
        }
        return (countA);
    }

    private static int diagonalLeft(int[][] brd, int p, int r, int c, int dir, int row){
        int countA = 0;
        int i = 0;
        while (i < row && c + row <= 18 && r + row * dir <= 18 && r + row * dir >= 0){
            if (brd[r + dir * (1 + i)][c + 1 + i] != (p % 2) + 1) {
                if (brd[r + dir * (1 + i)][c + 1 + i] == p)
                    countA++;
            }
            else if (brd[r + dir + i * dir][c + 1 + i] == (p % 2) + 1)
                return (0);
            i++;
        }
        return (countA);
    }

    private static int row(int[][] brd, int p, int r, int c, int row){
        //vertical up and down
        //System.out.println("r " + r + " c " + c);
        int val = vertical(brd, p, r, c, 1, row);
        val = Math.max(val, vertical(brd, p, r, c, -1, row));
        //horizontal right and left
        val = Math.max(val, horizontal(brd, p, r, c, 1, row));
        val = Math.max(val, horizontal(brd, p, r, c, -1, row));
        //diagonal Right up and down
        val = Math.max(val, diagonalRight(brd, p, r, c, -1, row));
        val = Math.max(val, diagonalRight(brd, p, r, c, 1, row));
        //diagonal left up and down
        val = Math.max(val, diagonalLeft(brd, p, r, c, -1, row));
        val = Math.max(val, diagonalLeft(brd, p, r, c, 1, row));
        return (val);
    }

    private static int[] brdLimits(int[][] brd){
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
                    limits[2] = Math.max(limits[2], j);//right
                    limits[3] = Math.max(limits[3], i);//lower
                }
                j++;
            }
            i++;
        }
        return (limits);
    }

}
