public class ValidMove extends DoubleThree{
    int countHorizontal(WorkingBoard workingBoard){
        int lastY = workingBoard.getLastY();
        int tempX = workingBoard.getLastX();
        int count = 1;

        while (tempX > 0 && workingBoard.getBoard()[lastY][tempX - 1] == workingBoard.getLastPlayed()){
            count++;
            tempX--;
        }
        tempX = workingBoard.getLastX();
        while (tempX < 18 && workingBoard.getBoard()[lastY][tempX + 1] == workingBoard.getLastPlayed()){
            count++;
            tempX++;
        }
        return count;
    }


    int countVertical(WorkingBoard workingBoard){
        int lastX = workingBoard.getLastX();
        int tempY = workingBoard.getLastY();
        int count = 1;

        while (tempY > 0 && workingBoard.getBoard()[tempY - 1][lastX] == workingBoard.getLastPlayed()){
            count++;
            tempY--;
        }
        tempY = workingBoard.getLastY();
        while (tempY < 18 && workingBoard.getBoard()[tempY + 1][lastX] == workingBoard.getLastPlayed()){
            count++;
            tempY++;
        }
        return count;
    }


    int countDiagonals(WorkingBoard workingBoard){
        int tempY = workingBoard.getLastY();
        int tempX = workingBoard.getLastX();
        int count = 1;

        while (tempX > 0 && tempY > 0 && workingBoard.getBoard()[tempY - 1][tempX - 1] == workingBoard.getLastPlayed()){
            tempX--;
            tempY--;
            count++;
        }
        tempX = workingBoard.getLastX();
        tempY = workingBoard.getLastY();
        while (tempX < 18 && tempY < 18 && workingBoard.getBoard()[tempY + 1][tempX + 1] == workingBoard.getLastPlayed()){
            tempX++;
            tempY++;
            count++;
        }
        if (count == 3)
            return count;
        count = 1;
        tempX = workingBoard.getLastX();
        tempY = workingBoard.getLastY();
        while (tempX < 18 && tempY > 0 && workingBoard.getBoard()[tempY - 1][tempX + 1] == workingBoard.getLastPlayed()){
            tempX++;
            tempY--;
            count++;
        }
        tempX = workingBoard.getLastX();
        tempY = workingBoard.getLastY();
        while (tempX > 0 && tempY < 18 && workingBoard.getBoard()[tempY + 1][tempX - 1] == workingBoard.getLastPlayed()){
            tempX--;
            tempY++;
            count++;
        }
        return count;
    }


    boolean isWinMove(WorkingBoard workingBoard){
        int horizontal = countHorizontal(workingBoard);
        int vertical = countVertical(workingBoard);
        int diagonal = countDiagonals(workingBoard);
        if (horizontal == 5 || vertical == 5 || diagonal == 5) {
            System.out.println("Player " + workingBoard.getLastPlayed() + " has won the game");
            return true;
        }
        return false;
    }
}
