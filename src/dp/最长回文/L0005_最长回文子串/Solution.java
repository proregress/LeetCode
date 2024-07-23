package dp.最长回文.L0005_最长回文子串;

public class Solution {
    public String longestPalindrome(String s){
        int length = s.length();

        if(length == 1) return s;
        if(length == 2 && s.charAt(0) == s.charAt(1)) return s;

        int maxLen = Integer.MIN_VALUE;
        String ans = "";
        boolean[][] dp = new boolean[length][length];
        // len = 1
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            maxLen = 1;
            ans = s.substring(i,i+1);
        }
        // len = 2
        for (int i = 0; i < length-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                maxLen = 2;
                ans = s.substring(i,i+2);
            }
        }
        // len = 3
        for(int len = 3; len <= length; len++){
            for (int i = 0 ; i < length ; i++){
                int j = i+len-1;
                if(j >= length) break; //越界
                if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    if(len >= maxLen){
                        maxLen = len;
                        ans = s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;
    }
}
