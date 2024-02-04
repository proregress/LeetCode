package array.前缀和.L0560_和为k的子数组;

/**
 * 普通的未经优化的前缀和
 */
public class Solution {
    int[] preSum;

    public int subarraySum(int[] nums, int k) {
        preSum = new int[nums.length+1];
        preSum[0] = 0;
        for(int i = 1; i < preSum.length; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        return count(k);
    }

    private int count(int k){
        int count = 0;
        for(int i = 1 ; i < preSum.length; i++){
            for(int j = 0 ; j < i; j++){
                // 子数组 nums[j..i-1] 的元素和，根据这个，可以知道 i 应该从1开始，j 要< i
                if(preSum[i] - preSum[j] == k){
                    count++;
                }
            }
        }
        return count;
    }

}
