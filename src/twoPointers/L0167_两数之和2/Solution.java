package twoPointers.L0167_两数之和2;

public class Solution {
    /**
     *  双指针，左右指针
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0 , right = numbers.length-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if (sum == target){
                return new int[]{left+1, right+1};
            }else if(sum > target){
                right--;
            }else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
