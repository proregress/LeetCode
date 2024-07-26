package 数据结构.数组.L0416_分割等和子集;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_failureDFS {
    static LinkedList<Integer> track = new LinkedList<>();
    static List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
        boolean b = canPartition(nums);
        System.out.println("b = " + b);
    }
    public static boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum % 2 == 1) return false;

        Arrays.sort(nums);
        int target = totalSum / 2;
        boolean ans = dfs(nums,0,target,0);
        return ans;
    }

    // 求子集
    public static boolean dfs(int[] nums, int start, int target, int sum){
        if(start == nums.length) return false;
        if(sum == target){
            result.add(new LinkedList<>(track));
            return true;
        }
        for (int i = start; i < nums.length; i++) {
            if(sum < target) {
                sum = sum + nums[i];
                track.add(nums[i]);
                dfs(nums, i+1, target, sum);
                sum = sum - nums[i];
                track.removeLast();
            }
        }
        return false;
    }
}
