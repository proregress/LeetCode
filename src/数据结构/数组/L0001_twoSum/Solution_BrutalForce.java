package 数据结构.数组.L0001_twoSum;

/**
 * @author xufan
 * @since 2024/07/22 22:25
 */

public class Solution_BrutalForce {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
