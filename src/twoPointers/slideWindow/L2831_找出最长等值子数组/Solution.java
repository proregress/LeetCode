package twoPointers.slideWindow.L2831_找出最长等值子数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static int longestEqualSubarray(List<Integer> nums, int k) {
        int ans = 0;

        // map ：key - 每个数字， value - 每个数字在nums中的下标序列
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.size() ; i++){
            map.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }

        // 遍历每个下标序列
        for(List<Integer> pos : map.values()){
            /*
            固定 r = pos.size()-1不对，nums=[4,2,7,2,1,7,2],k=1时，答案为1，固定r的结果为1
            */
            /*// 对于每个下标序列来说，固定 r = pos.size()-1；
            // l = 0 从左往右移动，逐渐缩小窗口，直到pos[r] - pos[l] - (r - l) <= k
            int r = pos.size() - 1;
            int l = 0;
            while(pos.get(r) - pos.get(l) - (r - l) > k){
                 l++;
            }*/

            /*
            在这里没有对左边界l的范围做限制，但l是不会超的，
            因为l最多等于r的时候，while括号内左边的结果为0， k最小为0，0 > 0 不成立，所以l不会继续++
            */
//            for(int l = 0, r = 0 ; r < pos.size(); r++){
//                while(pos.get(r) - pos.get(l) - (r - l) > k){
//                    l++;
//                }
//                ans = Math.max(ans , r - l + 1);
//            }

            // 模板写法，与上式相等
            int l = 0, r = 0;
            while(r < pos.size()){
                while(pos.get(r) - pos.get(l) - (r - l) > k){
                    l++;
                }
                ans = Math.max(ans , r - l + 1);
                r++;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(2);
        nums.add(7);
        nums.add(2);
        nums.add(1);
        nums.add(7);
        nums.add(2);
        longestEqualSubarray(nums, 1);
    }
}
