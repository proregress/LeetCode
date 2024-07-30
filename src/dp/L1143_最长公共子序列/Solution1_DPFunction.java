package dp.L1143_最长公共子序列;

import java.util.Arrays;

/**
 * TODO ; 还可以自底向上：https://mp.weixin.qq.com/s/ZhPEchewfc03xWv9VP3msg
 */
public class Solution1_DPFunction {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        memo = new int[m][n];
        // 备忘录值为 -1 代表未曾计算
        for(int[] row : memo){
            Arrays.fill(row,  -1 );
        }
        return dp(text1, 0, text2, 0);
    }

    // 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
    int dp(String s1, int i, String s2, int j){
        // base case:是i == len(s1)或j == len(s2)时，因为这时候s1[i..]或s2[j..]就相当于空串了，最长公共子序列的长度显然是 0
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        // 如果之前计算过，则直接返回备忘录中的答案
        if(memo[i][j] != -1){
            return memo[i][j];
        }

        // 根据 s1[i] 和 s2[j] 的情况做选择
        // 首先，如果word1[i] = word2[j], 则该字符一定在LCS中
        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = 1 + dp(s1, i+1, s2, j+1);
        }else {
            // 接着，如果word1[i] != word2[j] , 有三种情况
            // 情况1：word1[i]不在LCS中
            // 情况2：word2[j]不在LCS中
            // 情况3：word1[i]和word2[j]都不在LCS中
            // 返回max的情况即可
            memo[i][j] = max(dp(s1, i+1, s2, j), dp(s1, i, s2, j+1), dp(s1, i+1, s2, j+1));
        }
        return memo[i][j];
    }


    private int max(int i , int j , int k){
        return i > j ? Math.max(i, k) : Math.max(j, k);
    }
}
