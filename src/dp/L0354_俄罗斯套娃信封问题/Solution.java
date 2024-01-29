package dp.L0354_俄罗斯套娃信封问题;

import java.util.*;

/**
 * 纯dp 又双超时，我真服了
 */
public class Solution {

    public int maxEnvelopes(int[][] envelopes) {
        // 初步思路正确：需要给二维数组排序
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]){
                    return b[1] - a[1]; //降序
                }else {
                    return a[0] - b[0]; //升序
                }
            }
        });

        //对高度数组寻找最长递增子序列
        int[] heights = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            heights[i] = envelopes[i][1];
        }

        return LIS(heights);

    }

    /**
     * 返回heights数组中的最长递增子序列
     * @param heights
     * @return
     */
    private int LIS(int[] heights){
        int res = 0;
        int[] dp = new int[heights.length];
        Arrays.fill(dp,1);

        for(int i = 0 ; i < heights.length; i++){
            for (int j = 0 ; j < i ; j++){
                if(heights[i] > heights[j]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
        }

        for(int i = 0 ; i < heights.length; i++){
            res = Math.max(res, dp[i]);
        }

        return res;
    }


}
