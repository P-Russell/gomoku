public class BoardHeuristic {

    public  static int[][] heuristic(Board board, int[][] brd, int p){
        int[][] brdSol = new int[19][19];
        CheckMove valid = new CheckMove();
        int rl = (board.getDownRight().y + 2 < 18) ? (board.getDownRight().y + 2) : 18;
        int cl = (board.getDownRight().x + 2 < 18) ? (board.getDownRight().x + 2) : 18;
        int i = (board.getUpLeft().y - 2 >= 0) ? board.getUpLeft().y - 2 : 0;

        while (i <= rl){
            int j = (board.getUpLeft().x - 2 >= 0) ? board.getUpLeft().x - 2 : 0;
            while (j <= cl){
                if (brd[i][j] == 0 && (valid.isCaptureMove(board, i, j) || !valid.isDoubleThree(board, i, j))) {
                    //System.out.println("check");
                    int pl = (row(brd, p, i, j, 4) == 4) ? 2500 : 0;
                    int op = (row(brd, (p % 2) + 1, i, j, 4) == 4) ? 2400 : 0;
                    int pl1 = (row(brd, p, i, j, 4) == 3) ? 2000 : 0;
                    int op1 = (row(brd, (p % 2) + 1, i, j, 4) == 3) ? 1900 : 0;
                    int pl2 = (row(brd, p, i, j, 3) == 3) ? 2200 : 0;
                    int op2 = (row(brd, (p % 2) + 1, i, j, 3) == 3) ? 2100 : 0;
                    int st = (valid.singleThree(board, i, j)) ? 1800 : 0;
                    pl2 = Math.max(pl2, op2);
                    pl = Math.max(pl, op);
                    pl1 = Math.max(pl1, op1);
                    pl2 = Math.max(pl2, st);
                    pl1 = Math.max(pl1, pl2);
                    brdSol[i][j] = Math.max(pl, pl1);
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
        int[][] brdSol = heuristic(board, brd, p);
        int rl = (board.getDownRight().y + 2 < 18) ? (board.getDownRight().y + 2) : 18;
        int cl = (board.getDownRight().x + 2 < 18) ? (board.getDownRight().x + 2) : 18;
        int i = (board.getUpLeft().y - 2 >= 0) ? board.getUpLeft().y - 2 : 0;
        int y = 19;
        int x = 19;
        Move val = new Move(0, 0, 0);
        while (i <= rl){
            int j = (board.getUpLeft().x - 2 >= 0) ? board.getUpLeft().x - 2 : 0;
            while (j <= cl){
                if (brdSol[i][j] != 0 && val.piece <= brdSol[i][j]) {
                    if (val.piece < brdSol[i][j]) {
                        val.piece = brdSol[i][j];
                        y = Math.abs(board.getLastY() - i);
                        x = Math.abs(board.getLastX() - j);
                        val.y = i;
                        val.x = j;
                    }
                    else if (val.piece == brdSol[i][j]){
                        if (y >= Math.abs(board.getLastY() - i) || x >= Math.abs(board.getLastX() - j)){
                            y = Math.abs(board.getLastY() - i);
                            x = Math.abs(board.getLastX() - j);
                            val.y = i;
                            val.x = j;
                        }
                    }
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

}
