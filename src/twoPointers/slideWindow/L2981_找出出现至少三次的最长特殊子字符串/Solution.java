package twoPointers.slideWindow.L2981_找出出现至少三次的最长特殊子字符串;

import java.util.HashMap;

public class Solution {
    public int maximumLength(String s) {

        int ans = Integer.MIN_VALUE;

        HashMap<String, Integer> map = new HashMap<>();
        // 双指针：左指针从0开始依次前进，右指针从左指针的位置开始，向前移动直到下一个字符不一样了
        // 使用map记录子串和其对应出现次数
        for (int left = 0; left < s.length(); left++) {
            int right = left;
            char ch = s.charAt(right);
            String subString = String.valueOf(ch);
            map.put(subString, map.getOrDefault(subString, 0) + 1);
            right++;
            while(right < s.length()){
                if(s.charAt(right) != ch){
                    break;
                }
                subString = subString + s.charAt(right);
                map.put(subString, map.getOrDefault(subString, 0) + 1);
                right++;
            }
        }

        for(String sub : map.keySet()){
            if(map.get(sub) >= 3){
                ans = Math.max(ans, sub.length());
            }
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;


    }
}
