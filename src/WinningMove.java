public class WinningMove {
    int countHorizontal(Board board){
        int lastY = board.getLastY();
        int tempX = board.getLastX();
        int count = 1;

        while (tempX > 0 && board.getBoard()[lastY][tempX - 1] == board.getLastPlayed()){
            count++;
            tempX--;
        }
        tempX = board.getLastX();
        while (tempX < 18 && board.getBoard()[lastY][tempX + 1] == board.getLastPlayed()){
            count++;
            tempX++;
        }
        return count;
    }


    int countVertical(Board board){
        int lastX = board.getLastX();
        int tempY = board.getLastY();
        int count = 1;

        while (tempY > 0 && board.getBoard()[tempY - 1][lastX] == board.getLastPlayed()){
            count++;
            tempY--;
        }
        tempY = board.getLastY();
        while (tempY < 18 && board.getBoard()[tempY + 1][lastX] == board.getLastPlayed()){
            count++;
            tempY++;
        }
        return count;
    }


    int countDiagonals(Board board){
        int tempY = board.getLastY();
        int tempX = board.getLastX();
        int count = 1;

        while (tempX > 0 && tempY > 0 && board.getBoard()[tempY - 1][tempX - 1] == board.getLastPlayed()){
            tempX--;
            tempY--;
            count++;
        }
        tempX = board.getLastX();
        tempY = board.getLastY();
        while (tempX < 18 && tempY < 18 && board.getBoard()[tempY + 1][tempX + 1] == board.getLastPlayed()){
            tempX++;
            tempY++;
            count++;
        }
        if (count == 3)
            return count;
        count = 1;
        tempX = board.getLastX();
        tempY = board.getLastY();
        while (tempX < 18 && tempY > 0 && board.getBoard()[tempY - 1][tempX + 1] == board.getLastPlayed()){
            tempX++;
            tempY--;
            count++;
        }
        tempX = board.getLastX();
        tempY = board.getLastY();
        while (tempX > 0 && tempY < 18 && board.getBoard()[tempY + 1][tempX - 1] == board.getLastPlayed()){
            tempX--;
            tempY++;
            count++;
        }
        return count;
    }


    boolean isWinMove(Board board){
        int horizontal = countHorizontal(board);
        int vertical = countVertical(board);
        int diagonal = countDiagonals(board);
        if (horizontal >= 5 || vertical >= 5 || diagonal >= 5) {
            System.out.println("Player " + board.getLastPlayed() + " has won the game");
            return true;
        }
        return false;
    }
}
