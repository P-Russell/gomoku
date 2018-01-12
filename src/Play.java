import java.util.Scanner;
import java.util.Arrays;


public class Play {
    private static Scanner s = new Scanner(System.in);

    private static void getPlayMove(WorkingBoard workingBoard) {
        boolean success = false;

        while (!success) {
            System.out.println("enter the only the x and y coordinates of your move " +
                    "separated by a space or type exit, then press enter");
            String line = s.nextLine();
            if (line.trim().toLowerCase().equals("exit")) {
                workingBoard.setGameOver(true);
                return;
            }
            String[] values = line.trim().split("\\s+");
            try {
                if (values.length == 2) {
                    int inputX = Integer.parseInt(values[0]);
                    int inputY = Integer.parseInt(values[1]);
                    success = workingBoard.placeStone(inputX, inputY);
                } else
                    System.out.println("invalid input: " + Arrays.toString(values));
            } catch (NumberFormatException nfe) {
                System.out.println("invalid input: " + Arrays.toString(values));
            }
        }
    }

    public static void loop(WorkingBoard workingBoard) {

        while (!workingBoard.getGameOver()) {
            workingBoard.printBoard();
            getPlayMove(workingBoard);
        }
    }
}
