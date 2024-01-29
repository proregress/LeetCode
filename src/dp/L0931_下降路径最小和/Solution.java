package dp.L0931_下降路径最小和;

import java.util.Arrays;

public class Solution {
    static int[][] memo;

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int min = minFallingPathSum(matrix);

        System.out.println(min);
    }
    public static int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        //首先全部置为-1，便于下面dp方法中的判断
        //这里不对了，要注意题目给的数据范围，-1是有可能取到的，根据题目范围，要取一个大于10000的值
        for(int[] row : memo){
            Arrays.fill(row, 66666);
        }
        //然后由于下面要用到memo[0][i]，就先把这里的值填上
        for(int i = 0; i < n; i++){
            memo[0][i] = matrix[0][i];
        }

        for(int i = 0 ; i < n; i++){
            res = Math.min(res, dp(matrix, m-1, i));
        }
        return res;
    }

    /**
     * 返回从第一行出发到[row][col]位置的最小路径和
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    private static int dp(int[][] matrix, int row, int col){
        int m = matrix.length, n = matrix[0].length;
        //如果超出边界，返回一个很大的值
        if(row < 0 || col < 0 || row >= m || col >= n){
            return Integer.MAX_VALUE;
        }

        //base case, 如果是第一行，则就是方格本身
        if(row == 0){
            return matrix[0][col];
        }

        if(memo[row][col] != 66666){
            return memo[row][col];
        }

        int min1 = Math.min(dp(matrix, row - 1, col), dp(matrix, row - 1, col - 1));
        memo[row][col] =  matrix[row][col]+  Math.min(min1, dp(matrix, row - 1, col + 1));

        return  memo[row][col];

    }
}
