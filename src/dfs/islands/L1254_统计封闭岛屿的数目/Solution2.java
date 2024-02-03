package dfs.islands.L1254_统计封闭岛屿的数目;

/*
还有个办法，先从四条边开始dfs，只要跟四条边沾边的岛屿0全部变成水1，然后用拿到的新的grid计算岛屿数量
 */
public class Solution2 {
    //0-岛屿，1-水
    static int count = 0;

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,1,0,1,0,0,1,0},{1,1,0,1,1,0,1,1,1,0},{1,0,1,1,1,0,0,1,1,0},{0,1,1,0,0,0,0,1,0,1},{0,0,0,0,0,0,1,1,1,0},{0,1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,0,1},{1,1,1,1,1,1,0,0,0,0},{1,1,1,0,0,1,0,1,0,1},{1,1,1,0,1,1,0,1,1,0}};
        closedIsland(grid);
        System.out.println(count);//答案：5

    }

    public static int closedIsland(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int[] rows = new int[]{0, m-1};
        int[] cols = new int[]{0, n-1};
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                //先从四条边开始dfs，只要跟四条边沾边的岛屿0全部变成水1
                if(grid[i][j] == 0 && (i == 0 || j == 0 || i == m-1 || j == n-1 )){
                    dfs(grid,i,j);
                }
            }
        }
        //然后用拿到的新的grid计算岛屿数量
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0){
                    //每发现一个岛屿，就+1
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 岛屿0全部变成水1的dfs
     * @param grid
     * @param r
     * @param c
     */
    private static void dfs(int[][] grid, int r, int c){
        int m = grid.length, n = grid[0].length;
        // 超出索引边界
        if(r < 0 || c < 0 || r >= m || c >= n){
            return;
        }
        //已经是海水或者已经遍历过
        if(grid[r][c] != 0){
            return;
        }
        grid[r][c] = 1;
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }

}
