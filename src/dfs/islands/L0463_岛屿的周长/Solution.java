package dfs.islands.L0463_岛屿的周长;

/**
 * 核心：岛屿的周长就是岛屿方格和非岛屿方格相邻的边的数量。
 * 因此：每当在 DFS 遍历中，从一个岛屿方格走向一个非岛屿方格，就将周长加 1
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    return  dfs(grid, i , j);
                }
            }
        }
        return 0;
    }

    //每当在 DFS 遍历中，从一个岛屿方格走向一个非岛屿方格，就将周长加 1
    private int dfs(int[][] grid, int row, int col){
        int m = grid.length, n = grid[0].length;
        // 超出索引边界,走向了边界，因此+1
        if(row < 0 || col < 0 || row >= m || col >= n){
            return 1;
        }
        //是海水方格，走向了海域，因此+1
        if(grid[row][col] == 0){
            return 1;
        }
        //是陆地方格，走向了另一块陆地，因此不+1
        if(grid[row][col] == 2){
            return 0;
        }
        //初次踏足一块新的陆地，标记一下，表示来过
        grid[row][col] = 2;
        return dfs(grid, row-1, col)
                + dfs(grid, row+1, col)
                + dfs(grid, row, col-1)
                + dfs(grid, row, col+1);
    }


}
