package dp.L0072_编辑距离;

import java.util.Arrays;

public class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        memo = new int[m][n];
        // 备忘录值为 -1 代表未曾计算
        for(int[] row : memo){
            Arrays.fill(row,  -1 );
        }
        //i ， j从后往前遍历
        return dp(word1,m-1,word2,n-1);
    }

    int dp(String word1, int i, String word2, int j){
        //word1为空了，说明word2剩下的都要删掉
        if(i == -1) return j + 1;
        //word2为空了，说明word1剩下的都要删掉
        if(j == -1) return i + 1;

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)){
            //字符相等，跳过这个字符，去处理下一个字符
            memo[i][j] = dp(word1,i-1,word2,j-1);
        }else {
            //三种情况，三选一
            memo[i][j] = min(
/**
 * 详细解释：
 * 对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解：
 * 以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
 * (1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）
 * (2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
 * (3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
                     */
                    1 + dp(word1,i-1, word2,j), //增加一个字符
                    1 + dp(word1, i, word2,j-1), //删除一个字符
                    1 + dp(word1,i-1, word2,j-1)  //改变一个字符

            );
        }
        return memo[i][j];
    }

    int min(int i , int j , int k){
        return i < j ? Math.min(i,k) : Math.min(j,k);
    }
}
