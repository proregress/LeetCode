package 数据结构.数组.L0075_颜色分类;

/**
 * 暴力
 * todo：荷兰国旗问题，其他解法
 */
public class Solution {
    public void sortColors(int[] nums){
        int zero = 0, one = 0, two = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zero++;
            if (nums[i] == 1) one++;
            if (nums[i] == 2) two++;
        }
        int indexZero = 0, indexOne = indexZero + zero, indexTwo = indexOne + one;
        for (int i = 0; i < nums.length; i++) {
            if(i < indexOne){
                nums[i] = 0;
            }else if (i < indexTwo){
                nums[i] = 1;
            }else {
                nums[i] = 2;
            }
        }
    }
}
