public class DoubleThree {


    public boolean doubleThree(int[][] arr, int r, int c, int p){
        int[][] temp;
        temp = arr;
        temp[r][c] = p;
        if ((hor(temp, r, c) + ver(temp, r, c) + diagLft(temp, r, c) + diagRght(temp, r, c)) > 1)
            return (true);
        return (false);
    }

    //3 in a row
    private int hor(int[][] arr, int r, int c){
        int i = 0;
        while (i < 3 && i + c < 19){
            if (c - 2 + i > 0 && c + i < 18) {
                if (arr[r][c - 2 + i] == arr[r][c - 1 + i] && arr[r][c + i] == arr[r][c - 1 + i]) {
                    if (c - 3 + i >= 0 && arr[r][c - 3 + i] == 0){
                        if (c + i < 18 && arr[r][c + 1 + i] == 0)
                            return (1);
                    }
                }
            }
            i++;
        }
        //1101 last one
        if (c - 3 > 0 && arr[r][c - 3] == arr[r][c - 2] && arr[r][c - 2] == arr[r][c])
            if (arr[r - 4][c] == arr[r + 1][c] && arr[r + 1][c] == 0 && arr[r][c - 1] == 0)
                return (1);
        //1101 middle 1
        if (c - 1 > 0 && c + 2 < 18 && arr[r][c - 1] == arr[r][c] && arr[r][c] == arr[r][c + 2])
            if (arr[r][c - 2] == arr[r][c + 3] && arr[r][c + 3] == 0 && arr[r][c + 1] == 0)
                return (1);
        //1101 first one
        if (c > 0 && c + 3 < 18 && arr[r][c] == arr[r][c + 1] && arr[r][c + 1] == arr[r][c + 3])
            if (arr[r][c + 4] == arr[r][c - 1] && arr[r][c - 1] == 0 && arr[r][c + 2] == 0)
                return (1);

        //1011 last one
        if (c - 3 > 0 && arr[r][c - 3] == arr[r][c - 1] && arr[r][c - 1] == arr[r][c])
            if (arr[r - 4][c] == arr[r + 1][c] && arr[r + 1][c] == 0 && arr[r][c - 2] == 0)
                return (1);
        //1011 middle 1
        if (c - 2 > 0 && c + 1 < 18 && arr[r][c - 2] == arr[r][c] && arr[r][c] == arr[r][c + 1])
            if (arr[r][c - 3] == arr[r][c + 2] && arr[r][c + 2] == 0 && arr[r][c - 1] == 0)
                return (1);
        //1011 first one
        if (c > 0 && c + 3 < 18 && arr[r][c] == arr[r][c + 2] && arr[r][c + 2] == arr[r][c + 3])
            if (arr[r][c + 4] == arr[r][c - 1] && arr[r][c - 1] == 0 && arr[r][c + 1] == 0)
                return (1);
        return (0);
    }

    private int ver(int[][] arr, int r, int c){
        int i = 0;
        while (i < 3 && i + r < 19){
            if (r - 2 + i >= 0 && r + i < 19) {
                if (arr[r - 2 + i][c] == arr[r - 1 + i][c] && arr[r + i][c] == arr[r - 1 + i][c]) {
                    if (r - 3 + i >= 0 && arr[r - 3 + i][c] == 0)
                        if (r + i < 18 && arr[r + 1 + i][c] == 0)
                            return (1);
                }
            }
            i++;
        }
        //1101 last one
        if (r - 3 > 0 && arr[r - 3][c] == arr[r - 2][c] && arr[r - 2][c] == arr[r][c])
            if (arr[r - 4][c] == arr[r + 1][c] && arr[r + 1][c] == 0 && arr[r - 1][c] == 0)
                return (1);
        //1101 middle 1
        if (r - 1 > 0 && r + 2 < 18 && arr[r - 1][c] == arr[r][c] && arr[r][c] == arr[r + 2][c])
            if (arr[r - 2][c] == arr[r + 3][c] && arr[r + 3][c] == 0 && arr[r + 1][c] == 0)
                return (1);
        //1101 first one
        if (r > 0 && r + 3 < 18 && arr[r][c] == arr[r + 1][c] && arr[r + 1][c] == arr[r + 3][c])
            if (arr[r + 4][c] == arr[r - 1][c] && arr[r - 1][c] == 0 && arr[r + 2][c] == 0)
                return (1);

        //1011 last one
        if (r - 3 > 0 && arr[r - 3][c] == arr[r - 1][c] && arr[r - 1][c] == arr[r][c])
            if (arr[r - 4][c] == arr[r + 1][c] && arr[r + 1][c] == 0 && arr[r - 2][c] == 0)
                return (1);
        //1011 middle 1
        if (r - 2 > 0 && r + 1 < 18 && arr[r - 2][c] == arr[r][c] && arr[r][c] == arr[r + 1][c])
            if (arr[r - 3][c] == arr[r + 2][c] && arr[r + 2][c] == 0 && arr[r - 1][c] == 0)
                return (1);
        //1011 first one
        if (r > 0 && r + 3 < 18 && arr[r][c] == arr[r + 2][c] && arr[r + 2][c] == arr[r + 3][c])
            if (arr[r + 4][c] == arr[r - 1][c] && arr[r - 1][c] == 0 && arr[r + 1][c] == 0)
                return (1);
        return (0);
    }

    private int diagLft(int[][] arr, int r, int c){
        int i = 0;
        while (i < 3 && i + r < 19 && i + c < 19){
            if (r - 2 + i >= 0 && r + i < 19 && c - 2 + i >= 0 && c + i < 19) {
                if (arr[r - 2 + i][c - 2 + i] == arr[r - 1 + i][c - 1 + i] && arr[r + i][c + i] == arr[r - 1 + i][c - 1 + i]) {
                    if (r - 3 + i >= 0 && c - 3 + i >= 0 && arr[r - 3 + i][c - 3 + i] == 0)
                        if (r + i < 18 && c + i < 18 && arr[r + 1 + i][c + 1 + i] == 0)
                            return (1);
                }
            }
            i++;
        }
        //1101 last one
        if (r - 3 > 0 && c - 3 > 0 && arr[r - 3][c - 3] == arr[r - 2][c - 2] && arr[r - 2][c - 2] == arr[r][c])
            if (arr[r - 4][c - 4] == arr[r + 1][c + 1] && arr[r + 1][c + 1] == 0 && arr[r - 1][c - 1] == 0)
                return (1);
        //1101 middle 1
        if (r - 1 > 0 && r + 2 < 18 && c - 1 > 0 && c + 2 < 18 && arr[r - 1][c - 1] == arr[r][c] && arr[r][c] == arr[r + 2][c + 2])
            if (arr[r - 2][c - 2] == arr[r + 3][c + 3] && arr[r + 3][c + 3] == 0 && arr[r + 1][c + 1] == 0)
                return (1);
        //1101 first one
        if (r > 0 && r + 3 < 18 && c > 0 && c + 3 < 18 && arr[r + 1][c + 1] == arr[r][c] && arr[r][c] == arr[r + 3][c + 3])
            if (arr[r - 1][c - 1] == arr[r + 4][c + 4] && arr[r + 4][c + 4] == 0 && arr[r + 2][c + 2] == 0)
                return (1);

        //1011 last one
        if (r - 3 > 0 && c - 3 > 0 && arr[r - 3][c - 3] == arr[r - 1][c - 1] && arr[r - 1][c - 1] == arr[r][c])
            if (arr[r - 4][c - 4] == arr[r + 1][c + 1] && arr[r + 1][c + 1] == 0 && arr[r - 2][c - 2] == 0)
                return (1);
        //1011 middle 1
        if (r - 2 > 0 && r + 1 < 18 && c - 2 > 0 && c + 1 < 18 && arr[r - 2][c - 2] == arr[r][c] && arr[r][c] == arr[r + 1][c + 1])
            if (arr[r - 3][c - 3] == arr[r + 2][c + 2] && arr[r + 2][c + 2] == 0 && arr[r - 1][c - 1] == 0)
                return (1);
        //1011 first one
        if (r > 0 && r + 3 < 18 && c > 0 && c + 3 < 18 && arr[r + 2][c + 2] == arr[r][c] && arr[r][c] == arr[r + 3][c + 3])
            if (arr[r - 1][c - 1] == arr[r + 4][c + 4] && arr[r + 4][c + 4] == 0 && arr[r + 1][c + 1] == 0)
                return (1);
        return (0);
    }

    private int diagRght(int[][] arr, int r, int c){
        int i = 0;
        while (i < 3 && i + r < 18 && i + c < 18){
            if (r - 2 + i > 0 && r + i < 18 && c - 2 + i > 0 && c + i < 18) {
                if (arr[r - 2 + i][c + 2 - i] == arr[r - 1 + i][c + 1 - i] && arr[r + i][c - i] == arr[r - 1 + i][c + 1 - i]) {
                    if (r - 3 + i >= 0 && c + 3 + i < 18 && arr[r - 3 + i][c + 3 - i] == 0)
                        if (r + i < 18 && c - i - 1 >= 0 && arr[r + 1 + i][c - 1 - i] == 0)
                            return (1);
                }
            }
            i++;
        }
        //1101 last one
        if (r - 3 > 0 && c + 3 < 18 && arr[r - 3][c + 3] == arr[r - 2][c + 2] && arr[r - 2][c + 2] == arr[r][c])
            if (arr[r - 4][c + 4] == arr[r + 1][c - 1] && arr[r + 1][c - 1] == 0 && arr[r - 1][c + 1] == 0)
                return (1);
        //1101 middle 1
        if (r - 1 > 0 && r + 2 < 18 && c - 2 > 0 && c + 1 < 18 && arr[r - 1][c + 1] == arr[r][c] && arr[r][c] == arr[r + 2][c - 2])
            if (arr[r - 2][c + 2] == arr[r + 3][c - 3] && arr[r + 3][c - 3] == 0 && arr[r + 1][c - 1] == 0)
                return (1);
        //1101 first one
        if (r > 0 && r + 3 < 18 && c - 3 > 0 && c < 18 && arr[r + 1][c - 1] == arr[r][c] && arr[r][c] == arr[r + 3][c - 3])
            if (arr[r - 1][c + 1] == arr[r + 4][c - 4] && arr[r + 4][c - 4] == 0 && arr[r + 2][c - 2] == 0)
                return (1);

        //1011 last one
        if (r - 3 > 0 && c + 3 < 18 && arr[r - 3][c + 3] == arr[r - 1][c + 1] && arr[r - 1][c + 1] == arr[r][c])
            if (arr[r - 4][c + 4] == arr[r + 1][c - 1] && arr[r + 1][c - 1] == 0 && arr[r - 2][c + 2] == 0)
                return (1);
        //1011 middle 1
        if (r - 1 > 0 && r + 2 < 18 && c - 2 > 0 && c + 1 < 18 && arr[r - 1][c + 1] == arr[r][c] && arr[r][c] == arr[r + 2][c - 2])
            if (arr[r + 2][c - 2] == arr[r - 3][c + 3] && arr[r - 3][c + 3] == 0 && arr[r - 1][c + 1] == 0)
                return (1);
        //1011 first one
        if (r > 0 && r + 3 < 18 && c - 3 > 0 && c < 18 && arr[r + 2][c - 2] == arr[r][c] && arr[r][c] == arr[r + 3][c - 3])
            if (arr[r - 1][c + 1] == arr[r + 4][c - 4] && arr[r + 4][c - 4] == 0 && arr[r + 1][c - 1] == 0)
                return (1);
        return (0);
    }
}
