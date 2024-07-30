package sort.quickSort.L0215_数组中的第K个最大元素;

import java.util.Random;

/**
 * 简单快排，即使加了随机数，对于最后一个极端测试用例也会超时
 * 原因：快排对于以下2种数组效果很差：
 *      1. 完全顺序/逆序的数组，退化支O(N2)
 *      2. 包含大量重复元素的数组，交换失效。-> 需要升级为双路快排，让等于pivot的元素均匀地分布到数组的两端
 */
public class Solution_chaoshi {
    // 随机数，括号里是种子，目的是让每次随机数都不等
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int ans = findKthLargest(nums, 2);
        System.out.println("ans = " + ans);
    }
    public static int findKthLargest(int[] nums, int k) {
        // 第K个最大元素, 下标为nums.length-k
        int len = nums.length;
        int target = len - k;
        // 快排的思想
        int left = 0, right = len-1;
        while(true){
            int index = partition(nums, left, right);
            if(index == target){
                return nums[index];
            }else if (index > target){
                right = index - 1;
            }else if(index < target){
                left = index + 1;
            }
        }
    }

    /**
     * 此方法返回nums[left]应在的index
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] nums, int left, int right){
        // 随机数，否则无法通过最后一个极端测试用例
        // random.nextInt(right-left+1) : [0,right-left+1) -> [0,right-left]
        int randomIndex =left + random.nextInt(right-left+1);
        swap(nums, left, randomIndex);
        // 选定pivot
        int pivot = nums[left];

        int j = left;
        for(int i = left+1; i <= right; i++ ){
            if(nums[i] <= pivot){
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, left);

        return j;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
