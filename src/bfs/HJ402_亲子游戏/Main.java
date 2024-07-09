package bfs.HJ402_亲子游戏;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] offsets = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] grid = new int[N][N];
        int[][] step = new int[N][N]; //存步数
        int[][] candy = new int[N][N];//存糖果数

        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                step[i][j] = Integer.MAX_VALUE; // 初始每格步数设置为极大值，后续每层扩散，step[i][j]更新为正常步数
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == -3){ // 起点
                    candy[i][j] = 0;  // 起点糖果数量为0
                    step[i][j] = 0;   // 起点步数设置为0
                    queue.offer(new int[]{i,j});
                }
            }
        }

        boolean flag = false;
        int ans = -1;
        // bfs按层扩散
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                // 四方向扩散
                for(int[] offset : offsets){
                    int r = x + offset[0];
                    int c = y + offset[1];
                    if(r < 0 || c < 0 || r >= N || c >= N) continue;
                    if(grid[r][c] == -1)continue;

                    int curStep = step[x][y] + 1;
                    if(curStep > step[r][c]) continue;
                    step[r][c] = curStep;
                    /*int preCandyAmount = candy[x][y];
                    int curAmount = grid[r][c] == -2 ? preCandyAmount + 0 : preCandyAmount + grid[r][c];*/
                    int curAmount = candy[x][y] + Math.max(0, grid[r][c]);
                    candy[r][c] = Math.max(curAmount, candy[r][c]);
                    queue.offer(new int[]{r,c});
                    if(grid[r][c] == -2){
                        flag = true;
                        ans = candy[r][c];
                    }
                }
            }
            //一层结束
            if(flag) break;
        }
        System.out.println(ans);
    }
}
