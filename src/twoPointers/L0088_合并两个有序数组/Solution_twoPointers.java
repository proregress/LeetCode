package twoPointers.L0088_合并两个有序数组;

public class Solution_twoPointers {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3, n = 3;
        int[] nums2 = {2,5,6};
        merge(nums1,m,nums2,n);
        System.out.println("nums2 = " + nums2);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }
        int i = 0, j = 0;
        for (int k = 0; k < m + n; k++) {
            if(i == m){
                nums1[k] = nums2[j++];
            }else if(j == n){
                nums1[k] = temp[i++];
            }else if (temp[i] > nums2[j]){
                nums1[k] = nums2[j++];
            }else if (temp[i] <= nums2[j]){
                nums1[k] =temp[i++];
            }
        }
    }
}
