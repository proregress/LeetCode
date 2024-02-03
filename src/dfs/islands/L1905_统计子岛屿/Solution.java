package dfs.islands.L1905_统计子岛屿;

public class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        //0-sea, 1-island
        //先一个个对比每个对应格子，如果grid2中的某个格子是岛屿，而grid1中是海水，那肯定不是子岛屿了，直接把grid2的淹了，全部淹完后，grid2中剩下的就是子岛屿了，统计数量即可
        int count = 0;
        int m = grid1.length , n = grid1[0].length;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid1[i][j] != grid2[i][j]){
                    dfs(grid2, i ,j);
                }
            }
        }
        //统计grid2 岛屿数量
        for(int i = 0 ; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if(grid2[i][j] == 1){
                    dfs(grid2, i , j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int r, int c){
        int m = grid.length , n = grid[0].length;
        if(r < 0 || c < 0 || r >= m || c >= n){
            return;
        }
        if(grid[r][c] != 1){
            return;
        }
        grid[r][c] = 0;
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }

}
