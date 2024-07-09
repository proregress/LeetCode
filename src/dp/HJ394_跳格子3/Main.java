package dp.HJ394_跳格子3;

import java.util.Scanner;

/**
 * 要求：从最左到最右
 *
 * 6 （格子数量）
 * 1 -1 -6 7 -17 7 （每格分数）
 * 4 （最大步长k）
 * 输出：14
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[] scores = new int[n];
        int[] dp = new int[n]; //dp[i]定义：跳到第i个格子时的最大分数，dp[i] = max(dp[i-1],dp[i-2], ..., dp[i-k]) + scores[i]
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        dp[0] = scores[0];
        dp[1] = scores[0] + scores[1];

        for (int i = 2; i < n; i++) {
            // 此数字前面k个dp中的最大值
            int max = Integer.MIN_VALUE;
            for(int j = 1; j <= k ; j++){
                if(i-j >= 0){
                    max = Math.max(max,dp[i-j]);
                }
            }
            dp[i] = max + scores[i];
        }
        System.out.println(dp[n-1]);
    }
}
