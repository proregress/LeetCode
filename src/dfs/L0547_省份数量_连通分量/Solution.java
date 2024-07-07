package dfs.L0547_省份数量_连通分量;
/*
[[1,0,0,1],
 [0,1,1,0],
 [0,1,1,1],
 [1,0,1,1]]
 */
public class Solution {
    int province = 0;
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        for (int i = 0; i < cities; i++) {
            if(!visited[i]){
                province++;
                dfs(isConnected, i,visited);
            }
        }
        return province;
    }

    public void dfs(int[][] grid, int i, boolean[] visited){
        int cities = grid.length;
        for(int j = 0 ; j < cities ; j++){
            if(grid[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(grid, j, visited);
            }
        }
    }
}
