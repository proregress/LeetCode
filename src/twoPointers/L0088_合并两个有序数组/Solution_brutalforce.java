package twoPointers.L0088_合并两个有序数组;

import java.util.Collections;
import java.util.LinkedList;

public class Solution_brutalforce {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            list.add(nums2[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            nums1[i] = list.get(i);
        }
    }
}
