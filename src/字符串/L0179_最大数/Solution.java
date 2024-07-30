package 字符串.L0179_最大数;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        String s = largestNumber(nums);
        System.out.println("s = " + s);
    }
    public static String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if (strs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
