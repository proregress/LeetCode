package hj.HJ37_统计每个月兔子的总数;

/***
 方法三：动态规划：
 设第n个月的兔子数量为dp[n],第n个月有第n-1个月已有的兔子，同时，可能会有新出生的兔子。
 由题目可知，每只兔子在第三个月都会生一只兔子，所以第n个月出生的兔子数量等于第n-2月时的兔子数量，
 即dp[n]=dp[n-1]+dp[n-2]。
 ***/
import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            System.out.println(solution(n));
        }
    }

    public static int solution(int n){
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
