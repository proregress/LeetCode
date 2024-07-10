package 数据结构.数组.L0961_在长度2N的数组中找出重复N次的元素;

import java.util.HashMap;

// 暴力解，简单题
public class Solution {
    public int repeatedNTimes(int[] nums) {
        int ans = -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) >1 ){
                ans = nums[i];
            }
        }

        return ans;
    }
}
