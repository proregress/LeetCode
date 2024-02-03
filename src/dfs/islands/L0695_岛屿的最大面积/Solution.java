package dfs.islands.L0695_岛屿的最大面积;

public class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        for(int i = 0 ; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = area > maxArea ? area : maxArea;
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c){
        int m = grid.length , n = grid[0].length;
        // 超出索引边界
        if(r < 0 || c < 0 || r >= m || c >= n){
            return 0;
        }
        //是海水或者已经遍历过
        if(grid[r][c] != 1){
            return 0 ;
        }
        //初次踏足一块新的陆地，标记一下，表示来过
        grid[r][c] = 2;
        //同时面积+1
        return  1 + dfs(grid, r-1, c)
                 + dfs(grid, r+1, c)
                + dfs(grid, r, c-1)
                + dfs(grid, r, c+1);
    }
}
