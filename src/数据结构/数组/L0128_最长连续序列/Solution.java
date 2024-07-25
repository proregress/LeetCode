package 数据结构.数组.L0128_最长连续序列;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 去重+排序+双指针
 * O(NlogN)
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,100,4,200,1,3,2};
//        int[] nums = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
//        int[] nums = new int[]{1,2,3,4};
        int ans = longestConsecutive(nums);
        System.out.println("ans = " + ans);
    }
    public static int longestConsecutive(int[] nums) {
        // 特殊情况
        if(nums.length == 0) return 0;
        // 普通情况
        int ans = 1;
        // 去重
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // 排序
        List<Integer> collect = set.stream().sorted().collect(Collectors.toList());
        //双指针
        int l = 0;
        for(int r = l; r < collect.size(); r++){
            if(r == 0){
                continue;
            }else if(r > 0 && collect.get(r) - collect.get(r-1) == 1){
                continue;
            }else {
                ans = Math.max(ans, r-l);
                l = r;
            }
        }
        ans = Math.max(ans,collect.size()-l);
        return ans;
    }
}
