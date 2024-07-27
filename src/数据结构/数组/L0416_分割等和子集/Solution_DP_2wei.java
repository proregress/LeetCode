package 数据结构.数组.L0416_分割等和子集;

import java.util.Arrays;

public class Solution_DP_2wei {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) return false;

        int len = nums.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target+1];

        // target = 0 ，也就是第一列应该都为false，所有数字都是正整数，不可能得到和为0
        // nums[i] == j 时，dp=true
        for(int i = 0; i < len; i++){
            dp[i][nums[i]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];

                if(j == nums[i]) {
                    dp[i][j] = true;
                    continue;
                }
                if(j > nums[i]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];
    }
}
