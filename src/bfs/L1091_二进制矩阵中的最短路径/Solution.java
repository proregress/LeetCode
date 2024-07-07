package bfs.L1091_二进制矩阵中的最短路径;

import java.util.LinkedList;
import java.util.Queue;

/*
[[1,0,0],
 [1,1,0],
 [1,1,0]]
 */
public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        int i = shortestPathBinaryMatrix(grid);
        System.out.println("i = " + i);
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) return -1;
        int ans = 1;
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int[][] expands = new int[][]{{1,0},{1,1},{1,-1},{-1,0},{-1,1},{-1,-1},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                int[] poll = queue.poll();
                if(poll[0] == n-1 && poll[1] == m-1) return ans;
                for(int[] expand : expands){
                    int r = poll[0] + expand[0];
                    int c = poll[1] + expand[1];
                    if(r >= 0 && c >= 0 && r <n && c < m){
                        if(grid[r][c] != 0) continue;
                        if(visited[r][c]) continue;
                        visited[r][c] = true;
                        queue.offer(new int[]{r,c});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
