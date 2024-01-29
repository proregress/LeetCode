package dp.L0300_最长递增子序列;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int length = nums.length;
        //表示对于数组nums，以第i个下标的数结尾时，最长递增子序列长度是几
        int[] dp = new int[length];
        Arrays.fill(dp,1);

        for(int i = 0 ; i < length; i++){
            for(int j = 0 ; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],1 + dp[j]);
                }
            }
        }

        for(int i = 0 ; i < length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }


}
