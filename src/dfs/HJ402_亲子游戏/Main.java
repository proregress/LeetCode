package dfs.HJ402_亲子游戏;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<LinkedList<int[]>> pathList = new LinkedList<>();
    static LinkedList<LinkedList<int[]>> minLenPathList = new LinkedList<>();
    static LinkedList<int[]> path = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] grid = new int[N][N];
        int r = 0 , c = 0 , endR = 0, endC = 0;
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == -3){
                    r = i;
                    c = j; //起点
                }else if(grid[i][j] == -2){
                    endR = i;
                    endC = j; //终点
                }
            }
        }

        dfs(grid,r,c,endR,endC,visited);
        int minLen = Integer.MAX_VALUE;
        for(LinkedList<int[]> p : pathList){
            if(p.size() < minLen){
                minLen = p.size();
                minLenPathList.clear();
                minLenPathList.add(p);
            }else if(p.size() == minLen){
                minLenPathList.add(p);
            }
        }
        int maxCandies = Integer.MIN_VALUE;
        for(LinkedList<int[]> p : minLenPathList){
            int sum = 0 ;
            for(int[] cell : p){
                int num = grid[cell[0]][cell[1]];
                if(num >= 0){
                    sum = sum + num;
                }
            }
            maxCandies = Math.max(maxCandies, sum);
        }
        System.out.println(maxCandies);
    }

    public static void dfs(int[][] grid, int r, int c, int endR, int endC, boolean[][] visited){
        int n = grid.length;
        if(r < 0 || c < 0 || r >= n || c >= n) return;
        if(r == endR && c == endC) {
            pathList.add(new LinkedList<>(path));
            return;
        }
        if(grid[r][c] == -1) return;
        if(!visited[r][c]){
            visited[r][c] = true;
            path.add(new int[]{r,c});
            dfs(grid,r+1, c, endR, endC, visited);
            dfs(grid,r-1, c, endR, endC, visited);
            dfs(grid, r,c+1, endR, endC, visited);
            dfs(grid,r, c-1, endR, endC, visited);
            visited[r][c] = false;
            path.removeLast();
        }
    }
}
