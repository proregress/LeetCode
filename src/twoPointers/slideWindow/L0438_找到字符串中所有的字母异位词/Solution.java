package twoPointers.slideWindow.L0438_找到字符串中所有的字母异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams(s, p);
        System.out.println("res = " + res);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();

        if(s.length() < p.length()) return res;

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        // 关键在于这个使用valid变量记录两个哈希表是否比配的思想
        int valid = 0;
        while (right < s.length()){
            char rChar = s.charAt(right); // 即将进入窗口的字符
            right++;
            // 更新窗口内数据
            if(map.containsKey(rChar)){
                window.put(rChar, window.getOrDefault(rChar,0)+1);
                if(window.get(rChar).equals(map.get(rChar))){
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right-left >= p.length()){
                // 当窗口符合条件时，把起始索引加入res
                if(valid == map.size()){
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                //更新窗口内数据
                if(map.containsKey(d)){
                    if(window.get(d).equals(map.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return res;
    }
}
