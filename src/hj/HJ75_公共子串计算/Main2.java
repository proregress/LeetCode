package hj.HJ75_公共子串计算;

/*
方法二：动态规划
         * f[i][j]表示以str1第i个字符和str2第j个字符为结尾的公共子串的最大长度。
         * 分两种情况讨论。
         * 1、当str1(i)!=str2(j)时，结尾字符不同，所以以str1第i个字符和str2第j个字符为结尾的公共子串的最大长度为0,f[i][j]=0；
         * 2、当str1(i)==str2(j)时，结尾字符相同，所以f[i][j]=f[i-1][j-1]+1.
         * 初始条件：
         * f[0][j]=0,f[i][0]=0;
         * */
import java.util.Scanner;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int m = str1.length();
            int n = str2.length();

            int max = 0;

            int[][] dp = new int[m+1][n+1];

            for(int i = 0; i<=m; i++){
                for(int j = 0; j<=n; j++){
                    if(i==0 || j==0){
                        dp[i][j] = 0;
                    }else{
                        if(str1.charAt(i-1) != str2.charAt(j-1)){
                            dp[i][j] = 0;
                        }else{
                            dp[i][j] = dp[i-1][j-1] + 1;
                        }
                    }
                    max = Math.max(max,dp[i][j]);
                }
            }

            System.out.println(max);

        }
    }
}

