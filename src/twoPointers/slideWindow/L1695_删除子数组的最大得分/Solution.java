package twoPointers.slideWindow.L1695_删除子数组的最大得分;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5,2,1,2,5,2,1,2,5};
        int ans = maximumUniqueSubarray(nums);
        System.out.println("ans = " + ans);
    }
    public static int maximumUniqueSubarray(int[] nums) {
        // [5,2,1,2,5,1,2,5]
        HashSet<Integer> set = new HashSet<>();
        int maxSum = 0, sum = 0, l = 0, r = 0;
        while (r < nums.length){
            if(!set.contains(nums[r])){
                sum = sum + nums[r];
                set.add(nums[r]);
                maxSum = Math.max(sum , maxSum);
            }else {
                while (nums[r] != nums[l]){
                    sum = sum - nums[l];
                    set.remove(nums[l]);
                    l++;
                }
                l++;
            }
            r++;
        }
        return maxSum;
    }
}
