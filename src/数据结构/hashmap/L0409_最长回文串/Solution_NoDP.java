package 数据结构.hashmap.L0409_最长回文串;

import java.util.HashMap;

/**
 * 此题不需要dp，用hashmap
 */
public class Solution_NoDP {
    public static void main(String[] args) {
        String s = "tattarrattat";
        int i = longestPalindrome(s);
        System.out.println("i = " + i);
    }
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        // "ccc"
        if (map.keySet().size() == 1) {
            return s.length();
        }
        // "cccaaabbb"
        int ans = 0;
        boolean flag = true;
        for(Character c : map.keySet()){
            Integer i = map.get(c);
            if(i % 2 == 0) {
                ans += i;
            } else {
                ans += i-1;
                flag = false;
            }
        }
        ans = flag ? ans : ans+1;
        return ans;
    }
}
