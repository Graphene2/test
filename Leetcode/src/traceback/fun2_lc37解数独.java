package traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-22
 * Time: 21:09
 */
public class fun2_lc37解数独 {
    private int[] line = new int[9];
    private int[] column = new int[9];
    private int[] block = new int[9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    spaces.add(new int[]{i,j});
                }else {
                    int digit = board[i][j] - '0' - 1;
                    flip(i,j,digit);
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()){
            valid = true;
        }
        int[] space = spaces.get(pos);
        int i = space[0];
        int j = space[1];
        int mask = ~(line[i] | column[j] | block[i / 3 * 3 + j]) & 0x1ff;
        for (;mask != 0 && !valid; mask &= (mask - 1)){
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);
            dfs(board, pos + 1);
            flip(i, j, digit);
        }
    }

    private void flip(int i, int j, int digit) {
        line[i]  ^= 1 << digit;
        column[j] ^= 1 << digit;
        block[i / 3 * 3 + j] ^= 1 << digit;
    }
}
