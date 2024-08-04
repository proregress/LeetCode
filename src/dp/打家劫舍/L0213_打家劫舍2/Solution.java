package dp.打家劫舍.L0213_打家劫舍2;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int rob = rob(nums);
        System.out.println("rob = " + rob);
    }
    public static int rob(int[] nums) {
        // 要保证第一间和最后一间不同时偷窃
        // 1.偷第一间，就不能偷最后一间，范围[0,n-1]
        // 2.偷最后一间，就不能偷第一间，范围[1,n]
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        //第一次dp，范围[0,n-2]
        for (int i = 0; i < len-1; i++) {
            if(i == 0){
                dp1[i] = nums[i];
            }else if(i == 1){
                dp1[i] = nums[0] > nums[1] ? nums[0] : nums[1];
            }else {
                dp1[i] = Math.max(dp1[i-2] + nums[i] , dp1[i-1]);
            }
        }
        //第二次dp，范围[1,n-1]
        dp2[0] = 0; //注意，这里是0
        for (int i = 1; i < len; i++) {
            if(i == 1){
                dp2[i] = nums[i]; //注意这里的值
            }else {
                dp2[i] = Math.max(dp2[i-2] + nums[i] , dp2[i-1]);
            }
        }
        return Math.max(dp1[len-2],dp2[len-1]); //注意这里
    }
}
