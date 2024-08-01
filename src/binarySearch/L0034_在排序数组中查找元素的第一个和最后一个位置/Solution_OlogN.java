package binarySearch.L0034_在排序数组中查找元素的第一个和最后一个位置;

/**
 * 二分，尝试把时间复杂度降到O(logN)
 */
public class Solution_OlogN {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        int target = 2;
        int[] res = searchRange(nums, target);
        System.out.println("res = " + res);
    }
    public static int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int first = -1, last = -1;
        // 先找first的位置
        while(l <= r){
            int mid = l + (r-l) / 2;
            if(nums[mid] < target){
                l = mid+1;
            }else if(nums[mid] > target){
                r = mid-1;
            }else if(nums[mid] == target){
                first = mid;
                // 重点，之所以是mid-1，试想如果l = r = mid， 且mid位置上的数字正好是target，如果r=mid，那么while循环永远无法结束
                r = mid-1;
            }
        }
        // 再找last的位置
        l = 0;
        r = nums.length-1;
        while(l <= r){
            int mid = l + (r-l) / 2;
            if(nums[mid] < target){
                l = mid+1;
            }else if(nums[mid] > target){
                r = mid-1;
            }else if(nums[mid] == target){
                last = mid;
                // 重点，同上
                l = mid+1;
            }
        }

        return new int[]{first,last};
    }
}
