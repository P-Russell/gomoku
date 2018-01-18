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
            return (MinMax.bestMove(board));
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
