package dp.L0072_编辑距离;

import java.util.Arrays;

public class Solution_exercise {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for(int[] i : memo){
            Arrays.fill(i, -1);
        }
        return dp(word1,0,word2,0);
    }
    public int dp(String word1, int i, String word2, int j){
        // rised -> rise
        if(i == word1.length()) return word2.length()-j;
        if(j == word2.length()) return word1.length()-i;

        //备忘录剪枝，否则超时严重
        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)){
            //字符相等，跳过，去处理下一个
            memo[i][j] = dp(word1, i+1, word2, j+1);
        }else {
            // 三种情况
            memo[i][j] = 1 + min(
                    dp(word1, i+1, word2, j),    // 删除 raise -> rise
                    dp(word1, i, word2, j+1),    // 插入 rse -> rise
                    dp(word1, i+1, word2, j+1) //替换 rose -> rise
            );
        }
        return memo[i][j];
    }
    public int min(int a, int b, int c){
        return a > b ? Math.min(b,c) : Math.min(a, c);
    }
}
