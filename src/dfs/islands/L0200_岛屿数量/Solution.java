package dfs.islands.L0200_岛屿数量;

public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1'){
                    //每发现一个岛屿，就+1
                    dfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col){
        int m = grid.length, n = grid[0].length;
        // 超出索引边界
        if(row < 0 || col < 0 || row >= m || col >= n){
            return;
        }
        //已经是海水或者已经遍历过
        if(grid[row][col] != '1'){
            return;
        }
        grid[row][col] = 2;
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }

}
