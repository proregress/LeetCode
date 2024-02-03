package dp.L0712_两个字符串的最小ASCII删除和;

import java.util.Arrays;
//稍微变形，就有点转不过来了，还要再看。
public class Solution {

    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        memo = new int[m][n];
        // 备忘录值为 -1 代表未曾计算
        for(int[] row : memo){
            Arrays.fill(row,  -1 );
        }
        return dp(s1,0,s2,0);
    }

    //重新定义dp：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    int dp(String s1, int i, String s2, int j){
        int res = 0;
        if(i == s1.length()){
            //s1空了，则s2剩下的都需要删除掉
            for( ; j < s2.length() ; j++){
                res = res + s2.charAt(j);
            }
            return res;
        }

        if(j == s2.length()){
            //s2空了，则s1剩下的都需要删除掉
            for( ; i < s1.length() ; i++){
                res = res + s1.charAt(i);
            }
            return res;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            //相等字符，则不用删
            memo[i][j] = dp(s1, i+1, s2, j+1);
        }else {
            memo[i][j] = Math.min(
                    s1.charAt(i) + dp(s1, i+1, s2, j),
                    s2.charAt(j) + dp(s1, i, s2, j+1)
            );
        }

        return memo[i][j];
    }

}
