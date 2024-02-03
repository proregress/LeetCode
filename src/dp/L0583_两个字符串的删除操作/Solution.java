package dp.L0583_两个字符串的删除操作;

import java.util.Arrays;

public class Solution {
    /*
    思路： 先找到最长公共子序列，再分别减去多余字母
     */
    static int[][] memo;

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        int i = minDistance(word1, word2);
        System.out.println(i);
    }
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        memo = new int[m][n];
        for(int[] r : memo){
            Arrays.fill(r, -1);
        }
        int max = dp(word1, 0, word2,0);
        return m - max + n- max;
    }

    static int dp(String word1, int i, String word2, int j ){
        //base case
        if(i == word1.length() || j == word2.length()){
            return 0;
        }

        if (memo[i][j] != -1){
            return memo[i][j];
        }

        //如果两个字符相等，表示这个字符在LCS中
        if(word1.charAt(i) == word2.charAt(j)){
            memo[i][j] = 1 + dp(word1, i + 1, word2, j+1);
        }else {
            memo[i][j] = Math.max(dp(word1, i, word2, j+1) , dp(word1, i + 1, word2, j));
        }

        return memo[i][j];
    }

}
