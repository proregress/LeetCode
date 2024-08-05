package twoPointers.L0283_移动零;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,9,0,3,12,0,0,0,10};
        moveZeroes(nums);
        System.out.println();
    }
    public static void moveZeroes(int[] nums) {
        int i = 0; // 负责找0
        while (i < nums.length){
            if(nums[i] == 0){ // i找到0后，j继续向后遍历，负责找到第一个不为0的数，交换位置
                int j = i + 1;
                if(j >= nums.length) break;
                while (j < nums.length){
                    if(nums[j] != 0){
                        int temp = nums[j];
                        nums[j] = 0;
                        nums[i] = temp;
                        break;
                    }else {
                        j++;
                    }
                }
                i++;
            }else {
                i++;
            }
        }
    }
}
