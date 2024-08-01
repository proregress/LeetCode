package binarySearch.L0034_在排序数组中查找元素的第一个和最后一个位置;

/**
 * O(N), 从前往后依次遍历，一次定位到左右端点。
 */
public class Solution_ON {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,9};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println("res = " + res);
    }
    public static int[] searchRange(int[] nums, int target) {
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                left = i;
                break;
            }
        }
        if(left == -1){
            return new int[]{-1,-1};
        }
        int right = left;
        for (int j = left+1; j < nums.length; j++) {
            if(nums[j] != target){
                right = j-1;
                break;
            }else {
                right = j;
            }
        }
        return new int[]{left,right};
    }
}
