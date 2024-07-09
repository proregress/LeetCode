package dfs.HJ408_跳马;

import java.util.Scanner;

/**
 * dfs超时，使用BFS
 */
public class Main_chaoshi {
    static int m,n;
    static int minCount;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        String[][] grid = new String[m][n];
        for(int i = 0 ; i < m; i++){
            String str = sc.nextLine();
            for(int j = 0 ; j < n ; j++){
                grid[i][j] =String.valueOf(str.charAt(j));
            }
        }
        //遍历每一个格子，dfs看能否将所有马跳到这个格子上，能的话统计步数
        int minCount = Integer.MAX_VALUE;
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
               int count = allJumpToThisCell(grid, i, j);
               if(count != -1){
                   minCount = Math.min(minCount,count);
               }
            }
        }
        int res = minCount == Integer.MAX_VALUE ? -1 : minCount;
        System.out.println(res);
    }

    //判断是否每一匹马都能跳到[endR,endC]的位置上，能就返回步数，不能就返回-1
    public static int allJumpToThisCell(String[][] grid, int endR, int endC){
        int sum = 0;
        for(int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //此格不为马
                if(grid[i][j].equals(".")) continue;
                //此格为马
                int k = Integer.parseInt(grid[i][j]);
                boolean[][] visited = new boolean[m][n];
                minCount = Integer.MAX_VALUE;
                dfs(grid, i,j,endR, endC, 0, k , visited);
                if(minCount != Integer.MAX_VALUE){
                    sum = sum + minCount;
                }else {
                    return -1;
                }
            }
        }
        return sum;
    }

    public static void dfs(String[][] grid, int r, int c, int endR, int endC, int count, int k, boolean[][] visited){
        if(r < 0 || c < 0 || r >= m | c >= n){
            return;
        }
        if(r == endR && c == endC && k >= 0){
            minCount = Math.min(minCount,count);
            return;
        }
        if(visited[r][c]) return;

        visited[r][c] = true;
        count++;
        k--;
        dfs(grid,r+1, c+2, endR, endC, count, k, visited);
        dfs(grid,r+1, c-2, endR, endC, count, k, visited);
        dfs(grid,r+2, c+1, endR, endC, count, k, visited);
        dfs(grid,r+2, c-1, endR, endC, count, k, visited);
        dfs(grid,r-1, c+2, endR, endC, count, k, visited);
        dfs(grid,r-1, c-2, endR, endC, count, k, visited);
        dfs(grid,r-2, c+1, endR, endC, count, k, visited);
        dfs(grid,r-2, c-1, endR, endC, count, k, visited);
        count--;
        k++;
        visited[r][c] = false;
    }
}
