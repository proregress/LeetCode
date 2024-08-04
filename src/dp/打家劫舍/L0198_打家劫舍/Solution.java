package dp.打家劫舍.L0198_打家劫舍;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int rob = rob(nums);
        System.out.println("rob = " + rob);
    }
    public static int rob(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        //dp[i] 表示截止nums[i]的累计最大和
        //dp[i] = max(dp[i-2] + nums[i] , dp[i-1])
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        // 1, 10 , 3
        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i-2] + nums[i] , dp[i-1]);
        }
        return dp[len-1];
    }
}
