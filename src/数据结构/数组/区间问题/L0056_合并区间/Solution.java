package 数据结构.数组.区间问题.L0056_合并区间;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] i1 = new int[]{1,3};
        int[] i2 = new int[]{2,6};
        int[] i3 = new int[]{8,10};
        int[] i4 = new int[]{14,18};
        int[][] merge = merge(new int[][]{i1, i2, i3, i4});
        System.out.println("merge = " + merge);
    }
    public static int[][] merge(int[][] intervals){
        LinkedList<int[]> lists = new LinkedList<>();
        // 按照左端点升序排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        for(int[] arr : intervals){
            if(lists.size() > 0 && arr[0] <= lists.getLast()[1]){
                // 可以合并，更新右端点最大值
                lists.getLast()[1] = Math.max(arr[1],lists.getLast()[1]);
            }else {
                // 不可以合并，增加为新的节点
                lists.add(arr);
            }
        }

        int[][] ans = lists.toArray(new int[lists.size()][]);
        return ans;
    }
}
