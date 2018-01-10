public class Heuristic {

    private static int horizontalWinCount(int[][] board, int y, int x)
    {
        int deltaX = x - 5;

        for()
    }


    private static int countWindows(int[][] board, int y, int x)
    {

    }


    public static int value(int[][] board, int player)
    {
        int windowCount = 0;
        for(int y = 0; y < 19; y++)
        {
            for(int x = 0; x < 19; x++)
            {
                if(board[y][x] == player)
                    windowCount += countWindows(board, y, x);
            }

        }
    }
}
