package dp.L0055_跳跃游戏;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        boolean b = canJump(nums);
        System.out.println("b = " + b);
    }
    public static boolean canJump(int[] nums){
        // 定义dp[i]为是否能跳到i的位置
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        // dp[i] = (dp[0] && (0 + [1,nums[0]] == i ) ) || () || ()...
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(!dp[j]) continue;
                if(dp[j] && j + nums[j] >= i){
                    dp[i] = true;
                    break; // 剪枝
                }
            }
        }
        return dp[nums.length-1];
    }
}
