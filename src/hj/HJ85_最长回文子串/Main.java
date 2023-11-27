package hj.HJ85_最长回文子串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) { 
            String str = in.nextLine();
            int n = str.length(); //字符串的长度
            
            int maxLen = 1;
            
            boolean[][] dp = new boolean[n][n]; //dp[i][j] 表示str[i...j]是否是回文串
            
            //length == 1
            for(int i = 0; i<n; i++){
                dp[i][i] = true;
                maxLen = 1;
            }
            //length == 2
            for(int i = 0; i<n-1; i++){
                if(str.charAt(i) == str.charAt(i+1)){
                    dp[i][i+1] = true;
                    maxLen = 2;
                }else{
                    dp[i][i+1] = false;
                }
            }
            //length > 2
            for(int len = 3; len <= n; len++){
                for(int i = 0; i+len <= n; i++){
                    if(str.charAt(i) == str.charAt(i+len-1)){
                        dp[i][i+len-1] = dp[i+1][i+len-2];
                    }else{
                        dp[i][i+len-1] = false;
                    }
                    if(dp[i][i+len-1]){
                        maxLen = Math.max(maxLen,len);
                    }
                }
            }
            System.out.println(maxLen);
        }
    }
}
