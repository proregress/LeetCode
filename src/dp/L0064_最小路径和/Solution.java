package dp.L0064_最小路径和;

import java.util.Arrays;

/**
 * dfs 不适合此题，超时
 * @author xufan
 * @since 2024/01/28 20:54
 */

public class Solution {
    //备忘录，解决重叠子问题
    int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //构造备忘录，初始值全部设为-1，为啥呢
        memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }

        return dp(grid,m-1,n-1);
    }

    /**
     * 表示对于一个二维数组grid，从[0][0]走到[m-1][n-1]的最小路径和为dp(grid)
     * @param grid
     * @return
     */
    private int dp(int[][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;

        //base case ，不会写
        if(r == 0 && c == 0){
            return grid[0][0];
        }

        //这里思路正确：如果超出索引范围，则返回一个很大的值，保证在取min的时候不会被取到
        if(r < 0 || c < 0){
            return Integer.MAX_VALUE;
        }

        //避免重复计算
        if(memo[r][c] != -1){
            return memo[r][c];
        }

        /**
         * 这里完全不对，不需要双层for循环，直接返回那个语句
         */
        /*int res = Integer.MAX_VALUE;
        for(int i = 0; i < m ; i ++){
            for(int j = 0 ; j < n ; j++){
                res = grid[i][j] + Math.min(dp(grid,i-1, j), dp(grid,i,j-1));
            }
        }*/
        memo[r][c] = grid[r][c] + Math.min(dp(grid,r-1, c), dp(grid,r,c-1));

        return memo[r][c];

    }
}
