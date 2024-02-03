package dp.L0673_最长递增子序列的个数;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,4,3,5,4,7,2}; //12357,12347,12457, 对于7来说，它如何知道以5这个数结尾的最长LIS =4 时有两个情况呢
//        int[] nums = {2,2,2,2,2};
        int numberOfLIS = findNumberOfLIS(nums);
        System.out.println(numberOfLIS);
    }
    public static int findNumberOfLIS(int[] nums){
        int res = 0;
        int max = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1,nums.length);

        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        //这个数组用了存储以freq[i]结尾的最长LIS的个数
        int[] freq = new int[length];
        Arrays.fill(freq, 1);

//  int[] nums = {1,2,4,3,5,4,7,2}; //12357,12347,12457, 对于7来说，它如何知道以5这个数结尾的最长LIS =4 时有两个情况呢
        // 需要记录以5这个数结尾且len = 4 时， 数量 = 2
        for(int i = 0 ; i < length; i++){
            for(int j = 0 ; j < i; j++){
                if(nums[i] > nums[j]){
                    //对于刚刚的问题：[对于7来说，它如何知道以5这个数结尾的最长LIS =4 时有两个情况呢]，用下面这两种情况判断
                    if(dp[i] < 1+dp[j]){
                        freq[i] = freq[j];
                    }
                    if(dp[i] == 1+dp[j]){
                        freq[i] = freq[i] + freq[j];
                    }

                    dp[i] = Math.max(dp[i] , 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        for(int i = 0 ; i < length ; i++){
            if(dp[i] == max){
                res = res + freq[i];
            }
        }
        return res;

    }
}
