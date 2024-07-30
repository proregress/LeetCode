package dp.L1143_最长公共子序列;


/**
 * Solution1 dp是方法
 * Solution2 用dp数组
 */
public class Solution2_DPArray {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];

        // dp[i][j]=k 定义：text[0,i] 和text[0,j]的LCS是k
        // 1.dp[i][j] = 1 + dp[i-1][j-1];
        // 2.dp[i][j] = max(dp[i-1][j-1], dp[i][j-1], dp[i-1][j])
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = max(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public int max(int a, int b, int c){
        return a > b ? Math.max(a, c) : Math.max(b, c);
    }
}
