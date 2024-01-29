package dp.L0334_递增的三元子序列;

import java.util.Arrays;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        /**
         * 双重for循环，超时
         * TODO ： 用贪心解
         */
        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            if (dp[i] >= 3 ){
                return true;
            }
        }
        return false;

    }
}
