package dfs.islands.L1020_飞地的数量;

/*
grid =
[[0,0,0,0],
 [1,0,1,0],
 [0,1,1,0],
 [0,0,0,0]]
 */
public class Solution {
    //0-sea, 1-island
    int count = 0;
    public int numEnclaves(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        //将所有与边界有连接的陆地全部变为海洋
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (grid[i][j] == 1 && (i == 0 || j ==0 || i == m-1 || j == n-1) ){
                    dfs(grid, i, j);
                }
            }
        }
        //现在统计数量
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    int num = dfsCount(grid, i, j);
                    count = count + num;
                }
            }
        }
        return count;
    }

    /**
     * 将所有与边界有连接的陆地全部变为海洋的方法
     * @param grid
     * @param r
     * @param c
     */
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
        dfs(grid, r,c-1);
        dfs(grid, r,c+1);

    }

    /**
     * 统计数量的方法
     * @param grid
     * @param r
     * @param c
     */
    private int dfsCount(int[][] grid, int r, int c){
        int m = grid.length , n = grid[0].length;
        if(r < 0 || c < 0 || r >= m || c >= n){
            return 0;
        }
        if(grid[r][c] != 1){
            return 0;
        }
        grid[r][c] = 0;
        return 1 + dfsCount(grid, r-1, c)
                + dfsCount(grid, r+1, c)
                + dfsCount(grid, r,c-1)
                + dfsCount(grid, r,c+1);

    }
}
