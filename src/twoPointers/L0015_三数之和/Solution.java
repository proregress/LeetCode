package twoPointers.L0015_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 排序+双指针
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;// 跳过重复
            int num_i = nums[i];
            int left = i+1, right = nums.length-1;
            while(left < right){
                int sum = num_i + nums[left] + nums[right];
                if(sum == 0){
                    int[] arr = new int[]{num_i, nums[left], nums[right]};
                    result.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
                    left++;
                    right--;
                    // 跳过重复，重要
                    while(left < nums.length && nums[left] ==nums[left-1]){
                        left = left + 1;
                    }
                }else if(sum < 0){
                    left++;
                }else if(sum > 0){
                    right--;
                }
            }
        }
        return result;
    }
}
