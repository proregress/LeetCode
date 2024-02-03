package sort.mergeSort.L0912_排序数组;

/**
 * 归并排序
 */
public class Solution {

    // 用于辅助合并有序数组
    private int[] temp;

    public int[] sortArray(int[] nums) {
        // 先给辅助数组开辟内存空间
        temp = new int[nums.length];
        sort(nums, 0 , nums.length-1);
        return nums;
    }

    /**
     * 对nums[lo,hi]进行排序
     */
    void sort(int[] nums, int lo, int hi){
        if(lo == hi){
            // 单个元素不用排序
            return;
        }
        // 这样写是为了防止溢出，效果等同于 (hi + lo) / 2
        int mid = lo + (hi - lo) / 2;
//        int mid = (lo + hi) / 2;

        sort(nums, lo, mid);          // 先对左半部分数组 nums[lo..mid] 排序
        sort(nums, mid + 1 , hi); // 再对右半部分数组 nums[mid+1..hi] 排序

        merge(nums, lo, mid, hi);     // 将两部分有序数组合并成一个有序数组
    }

    /**
     * 将排序好的nums[lo, mid] 和nums[mid+1, hi] 进行双指针比较大小排成升序的nums[lo, hi]
     */
    void merge(int[] nums, int lo, int mid, int hi){
        // 无法原地排序，先把 nums[lo..hi] 复制到辅助数组中
        // 以便合并后的结果能够直接存入 nums
        /*for(int i = 0; i < nums.length; i++){
            temp[i] = nums[i];
        }*/
        //应该是这里导致超时，不是整个复制，而是分批复制
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }

        //双指针，指针分别指向nums[lo, mid] 和nums[mid+1, hi]的首位
        int i = lo, j = mid + 1;
        for(int k = lo ; k <= hi ; k++){
            if( i == mid + 1){
                //左半边数组已全部被合并
                nums[k] = temp[j++];
            }else if (j == hi + 1){
                //右半边数组已全部被合并
                nums[k] = temp[i++];
            } else if (temp[i] > temp[j]){
                nums[k] = temp[j++];
            } else {
                nums[k] = temp[i++];
            }
        }

    }

}
