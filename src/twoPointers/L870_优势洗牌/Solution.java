package twoPointers.L870_优势洗牌;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {5621,1743,5532,3549,9581};
        int[] nums2 = {913,9787,4121,5039,1481};
        int[] res = advantageCount(nums1, nums2);
        System.out.println("res = " + res);
    }
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        // 8  12 24 32
        // 11 13 25 32
        int len = nums1.length;
        Integer[] idx1 = new Integer[len];
        Integer[] idx2 = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx1[i] = i;
            idx2[i] = i;
        }
        // idx1 :      [0,   1,   2,   3，  4]
        // nums1 :     [5621,1743,5532,3549,9581]
        // 排序后idx1 : [1,   3,   2,   0，  4]
        // idx2 :      [0,   1,   2,   3，  4]
        // nums2 :     [913,9787,4121,5039,1481]
        // 排序后idx2 : [0,   4,   2,   3，  1]
        Arrays.sort(idx1, (i1,i2) -> nums1[i1] - nums1[i2]);
        Arrays.sort(idx2, (i1,i2) -> nums2[i1] - nums2[i2]);
        int left = 0, right = len-1;
        for(int i = 0 ; i < len; i++) {
            if(nums1[idx1[i]] > nums2[idx2[left]]){ // 很绕，这里要仔细对照原数组
                res[idx2[left]] = nums1[idx1[i]];
                left++;
            }else {
                res[idx2[right]] = nums1[idx1[i]];
                right--;
            }
        }
        return res;
    }
}
