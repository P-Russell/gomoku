import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class TerminalGame {

    public static Move getMoveFromTerminal(Board board, Player player) {
        Scanner s = new Scanner(System.in);
        CheckMove validator = new CheckMove();

        while (true) {
            System.out.println("enter the only the x and y coordinates of your move " +
                    "separated by a space");
            String line = s.nextLine();
            String[] values = line.trim().split("\\s+");
            try {
                if (values.length == 2) {
                    int inputX = Integer.parseInt(values[0]);
                    int inputY = Integer.parseInt(values[1]);
                    if (validator.validateAndCapturePieces(board, inputY, inputX)) {
                        Move move = new Move(inputY, inputX, player.getName());
                        return move;
                    } else
                        System.out.println("Error 1: Invalid values " + Arrays.toString(values));
                } else
                    System.out.println("Error 2: invalid input: " + Arrays.toString(values));
            } catch (NumberFormatException nfe) {
                System.out.println("Error 3: invalid input: " + Arrays.toString(values));
            }
        }
    }

    public static Move randomMove(Board board, Player player) {
        int x;
        int y;
        Random flip = new Random();
        CheckMove validator = new CheckMove();
        while (true) {
            x = flip.nextInt(board.getBoard().length);
            y = flip.nextInt(board.getBoard().length);
           // System.out.println("Testing Random x: " + x + " Random y: " + y);
            if (validator.validateAndCapturePieces(board, y, x)) {
               // System.out.println("Random x: " + x + " Random y: " + y);
                Move move = new Move(y, x, player.getName());
                return move;
            }
        }
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++)
            System.out.println(Arrays.toString(board[i]));
        System.out.println();
    }

    public static boolean exitGame() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Exit game? y/n");
            String line = s.nextLine();
            if (line.trim().toLowerCase().equals("y"))
                return false;
            else if (line.trim().toLowerCase().equals("n"))
                return true;
        }
    }
}
