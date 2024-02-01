package dp.L0053_最大子数组和;

/**
 * TODO:
 * 1. 空间压缩，提升空间复杂度：https://mp.weixin.qq.com/s/-JP7dc8_A5KWC394tQIV1g
 * 2. 前缀和思路：https://mp.weixin.qq.com/s/-JP7dc8_A5KWC394tQIV1g
 * 3. 分治算法
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-3, 4, -1 , 2, -6, 1, 4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }


    static int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        //dp[i]表示以nums[i]结尾的最大子数组的和
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
