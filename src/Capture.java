public class Capture {
    public Boolean capture(int[][] arr, int r, int c, int move){
        //down
        if (r <= 16)
            if (move == arr[r + 3][c] && arr[r + 1][c] != move && arr[r + 1][c] == arr[r + 2][c] & arr[r + 1][c] != 0) {
                arr[r + 1][c] = arr[r + 2][c] = 0;
                return (true);
            }
        //up
        if (r >= 3)
            if (move == arr[r - 3][c] && arr[r - 1][c] != move && arr[r - 1][c] == arr[r - 2][c] & arr[r - 1][c] != 0){
                arr[r - 1][c] = arr[r - 2][c] = 0;
                return (true);
            }
        //right
        if (c <= 16)
            if (move == arr[r][c + 3] && arr[r][c + 1] != move && arr[r][c + 1] == arr[r][c + 2] & arr[r][c + 1] != 0){
                arr[r][c + 1] = arr[r][c + 2] = 0;
                return (true);
            }
        //left
        if (c >= 3)
            if (move == arr[r][c - 3] && arr[r][c - 1] != move && arr[r][c - 1] == arr[r][c - 2] & arr[r][c - 1] != 0){
                arr[r][c - 1] = arr[r][c - 2] = 0;
                return (true);
            }
        //diag down left
        if (r <= 16 && c >= 3)
            if (move == arr[r + 3][c - 3] && arr[r + 1][c - 1] != move && arr[r + 1][c - 1] == arr[r + 2][c - 2] & arr[r + 1][c - 1] != 0){
                arr[r + 1][c - 1] = arr[r + 2][c - 2] = 0;
                return (true);
            }
        //diag down right
        if (r <= 16 && c < 16)
            if (move == arr[r + 3][c + 3] && arr[r + 1][c + 1] != move && arr[r + 1][c + 1] == arr[r + 2][c + 2] & arr[r + 1][c + 1] != 0){
                arr[r + 1][c + 1] = arr[r + 2][c + 2] = 0;
                return (true);
            }
        //diag up right
        if (c <= 16 && r >= 3)
            if (move == arr[r - 3][c + 3] && arr[r - 1][c + 1] != move && arr[r - 1][c + 1] == arr[r - 2][c + 2] & arr[r - 1][c + 1] != 0){
                arr[r - 1][c + 1] = arr[r - 2][c + 2] = 0;
                return (true);
            }
        //diag up left
        if (c >= 3 && r >= 3)
            if (move == arr[r - 3][c - 3] && arr[r - 1][c - 1] != move && arr[r - 1][c - 1] == arr[r - 2][c - 2] & arr[r - 1][c - 1] != 0){
                arr[r - 1][c - 1] = arr[r - 2][c - 2] = 0;
                return (true);
            }
        return (false);
    }
}
