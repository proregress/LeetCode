package dfs.islands.L1254_统计封闭岛屿的数目;

/*
[[0,0,1,1,0,1,0,0,1,0],
 [1,1,0,1,1,0,1,1,1,0],
 [1,0,1,1,1,0,0,1,1,0],
 [0,1,1,0,0,0,0,1,0,1],
 [0,0,0,0,0,0,1,1,1,0],
 [0,1,0,1,0,1,0,1,1,1],
 [1,0,1,0,1,1,0,0,0,1],
 [1,1,1,1,1,1,0,0,0,0],
 [1,1,1,0,0,1,0,1,0,1],
 [1,1,1,0,1,1,0,1,1,0]]
 */

public class Solution {
    //0-岛屿，1-水
    public int closedIsland(int[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0 ){
                    //每发现一个岛屿，就+1
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int row, int col){
        int m = grid.length, n = grid[0].length;
        // 超出索引边界
        if(row < 0 || col < 0 || row >= m || col >= n){
            return;
        }
        //已经是海水或者已经遍历过
        if(grid[row][col] !=  0){
            return;
        }
        //其次，如果在第2行/列或者倒数第2行/列的方格是岛屿，则需要保证紧挨着它的靠边界的那个方格也不是岛屿0
        /**
         * 这里，碰到沾边的岛屿不知道该怎么处理了
         */
        if( (row == 1 && grid[row-1][col] == 0) || (col == 1 && grid[row][col-1] == 0) || (row == m-2 && grid[row+1][col] == 0) || (col == n-2 && grid[row][col+1] == 0) ) {
            return;
        }
        grid[row][col] = 2;
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }
}
