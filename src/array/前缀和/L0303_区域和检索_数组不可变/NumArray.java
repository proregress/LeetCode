package array.前缀和.L0303_区域和检索_数组不可变;

public class NumArray {

    /* new 一个新的数组preSum出来，preSum[i]记录nums[0..i-1]的累加和 */
    private int[] preSum;
    /* 输入一个数组，构造这个数组的前缀和 */
    public NumArray(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for(int i = 1; i < preSum.length ; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }

    /* 查询闭区间 [left, right] 的累加和 */
    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }
}

