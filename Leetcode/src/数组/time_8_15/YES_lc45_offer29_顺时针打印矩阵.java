package 数组.time_8_15;

/**剑指offer29题/leetcode45题： 顺时针打印矩阵 经典题目。 优雅！！
 *
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,11:14-11:57
 * @version: 1.0
 */
public class YES_lc45_offer29_顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1;
        int t = 0 , b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true){
            for (int i = l; i <= r; i++ ) res[x++] = matrix[t][i];
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r];
            if (--r < l) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i];
            if (--b < t) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l];
            if (++l > r) break;
        }
        return res;
    }
}
