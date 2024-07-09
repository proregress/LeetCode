package bfs.HJ408_跳马;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        String[][] grid = new String[m][n];
        int count = 0; //统计共有几匹马
        for(int i = 0 ; i < m; i++){
            String s1 = sc.nextLine();
            for(int j = 0 ; j < n ; j++){
                grid[i][j] =String.valueOf(s1.charAt(j));
                if(!grid[i][j].equals(".")) count++;
            }
        }
        int[][] expands = new int[][]{{1,-2},{1,2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        int[][] res = new int[m][n]; // 存放每个格子最少跳到的次数和
        int[][] visitedCount = new int[m][n]; // 统计每个格子有几匹马跳到过，最后于所有匹数对比，不足的说明不是所有马都能跳到
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                boolean[][] visited = new boolean[m][n];
                if(!grid[i][j].equals(".")){
                    visitedCount[i][j]++;
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                    // 此马(i,j)限制步数为k
                    Integer k = Integer.valueOf(grid[i][j]);
                    int ki = 0;
                    while(!queue.isEmpty()){
                        ki++;
                        // 超出步数限制，不在扩散，直接返回
                        if(ki > k){
                            queue.clear(); //重要
                            break;
                        }
                        int size = queue.size();
                        for(int s = 0 ; s< size; s++){
                            int[] poll = queue.poll();
                            for(int[] expand : expands){
                                int r = poll[0] + expand[0], c = poll[1] + expand[1];
                                if(r < 0 || c < 0 || r >= m || c >= n) continue;
                                if(visited[r][c]) continue;
                                visited[r][c] = true;
                                res[r][c] = res[r][c] + ki;
                                queue.offer(new int[]{r,c});
                                visitedCount[r][c]++;
                            }
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visitedCount[i][j] == count){
                    ans = Math.min(ans, res[i][j]);
                }
            }
        }
        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        System.out.println(ans);
    }
}
