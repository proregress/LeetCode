package hj.odOnlineExam.test3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wa = sc.nextInt();
        int wb = sc.nextInt();
        int wt = sc.nextInt();
        int pa = sc.nextInt();
        int pb = sc.nextInt();

        //10 8 36 15 7
        //44
        //dp背包
        //定义dp[n] 为装了重量为n的货物后的最大利润
        //则dp[36] = 15 + dp[26], 7 + dp[29]
        // dp[26]=15 + dp[16]
        // dp[i] = max(pa + dp[i-wa] , pb + dp[i-wb])
        int[] dp = new int[wt+1];
        Arrays.fill(dp,-1);
        dp[wa] = pa;
        dp[wb] = pb;
        for(int i = wa+wb ; i <= wt; i++){
            if(dp[i-wa] == -1 && dp[i-wb] != -1){
                dp[i] = pb + dp[i-wb];
            }else if(dp[i-wb] == -1 && dp[i-wa] != -1) {
                dp[i] =  pa + dp[i-wa];
            }else if(dp[i-wb] != -1 && dp[i-wa] != -1){
                dp[i] = Math.max(pa + dp[i-wa], pb + dp[i-wb]);
            }
        }
        System.out.println(dp[wt]);

    }
}
