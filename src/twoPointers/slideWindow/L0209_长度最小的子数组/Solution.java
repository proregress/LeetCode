package twoPointers.slideWindow.L0209_长度最小的子数组;

public class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;

        int l = 0, r = 0;
        int sum = 0;
        while(r < nums.length){
            sum = sum + nums[r];
            while(sum >= target){
                ans = Math.min(ans, r-l+1);
                sum = sum - nums[l];
                l++;
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        int target = 100;
        int i = minSubArrayLen(target, nums);
        System.out.println("i = " + i);
    }
}
