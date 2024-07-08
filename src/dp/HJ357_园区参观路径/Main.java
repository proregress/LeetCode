package dp.HJ357_园区参观路径;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] grid = new int[n][m];
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        //DP
        // 定义dp[i][j] 为走到(i,j)这个位置有dp[i][j] 种方式，所以dp[i][j] =dp[i-][j]  + dp[i][j-1]
        if(grid[0][0] != 0 || grid[n-1][m-1] != 0) {
            System.out.println("0");
            return;
        };
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) continue;
                if(i == 0 && j == 0){
                    dp[i][j] =1;
                    continue;
                }
                if(i-1 >= 0 && grid[i-1][j] == 0 && j-1 >= 0 && grid[i][j-1] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }else if(i-1 >= 0 && grid[i-1][j] == 0){
                    dp[i][j] = dp[i-1][j];
                }else if(j-1 >= 0 && grid[i][j-1] == 0){
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        System.out.println("dp[n-1][m-1] = " + dp[n - 1][m - 1]);
    }
}
