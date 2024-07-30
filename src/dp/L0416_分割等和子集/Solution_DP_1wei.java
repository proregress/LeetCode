package dp.L0416_分割等和子集;

import java.util.Arrays;

/**
 * 空间压缩，二维压成一维
 * j要逆序
 */
public class Solution_DP_1wei {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) return false;

        int len = nums.length;
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];

        // target = 0 ，也就是第一列应该都为false，所有数字都是正整数，不可能得到和为0
        // nums[i] == j 时，dp=true
        if(nums[0] <= target){
            dp[nums[0]] = true;
        }
        for(int i = 1; i < len; i++){
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }

        return dp[target];
    }
}
