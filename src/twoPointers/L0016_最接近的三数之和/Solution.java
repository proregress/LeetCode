package twoPointers.L0016_最接近的三数之和;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * dfs超时
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int differ = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length; i++){
            int num_i = nums[i];
            int left = i+1, right = nums.length-1;
            while(left < right){
                int sum = num_i + nums[left] + nums[right];
                int curDiffer = Math.abs(sum - target);
                // 如果相等，直接返回
                if(curDiffer == 0){
                    ans = target;
                    return ans;
                }
                // 差值更小，更新ans
                if(curDiffer <= differ){
                    ans = sum ;
                    differ = curDiffer;
                }
                // 根据sum和target的大小更新左右边界
                if(sum > target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return ans;
    }
}
