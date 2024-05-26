package twoPointers.slideWindow.L1234_替换子串得到平衡字符串;

import java.util.HashMap;
import java.util.Set;

public class Solution {
    public static int balancedString(String s) {
        int ans = Integer.MAX_VALUE;

        // QWQQQERQ
        // 题目转化为：
        // 统计每个字符出现的次数，
        // 如果只有一个字符出现的次数count > 平均值avg，则：找到包含(count-avg)个这个字符的最短字串
        // 如果有两个字符出现的次数count1，count2 都 > 平均值 avg， 则：找到包含count1-avg个字符1和count2-avg个字符2的最短字串
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> chMap = new HashMap<>();
        int avg = s.length() / 4;
        for(char c : s.toCharArray()){
            map.put(c , map.getOrDefault(c, 0 ) + 1);
        }
        for(char c : map.keySet()){
            if(map.get(c) > avg){
                chMap.put(c, map.get(c) - avg);
            }
        }
        if(chMap.size() == 0){
            return 0;
        }

        // WQEQQRQQ
        // QWQQQERQ
        if(chMap.size() == 1){
            char ch = (char)chMap.keySet().toArray()[0];
            Integer count = chMap.get(ch);
            int l = 0, r = 0;
            int sum = 0;
            while(r < s.length()){
                if(ch == s.charAt(r)){
                    sum++;
                }
                while(sum >= count){
                    ans = Math.min(ans , r-l+1);
                    if(ch == s.charAt(l)){
                        sum--;
                    }
                    l++;
                }
                r++;
            }
        }else if(chMap.size() == 2){
            //String s = "WWWEQRQEWWQQQWQQQWEWEEWRRRRRWWQE"; //1Q3W
            char ch1 = (char)chMap.keySet().toArray()[0];
            char ch2 = (char)chMap.keySet().toArray()[1];
            Integer count1 = chMap.get(ch1);
            Integer count2 = chMap.get(ch2);

            int l = 0, r = 0;
            HashMap<Character, Integer> tempMap = new HashMap<>();
            while(r < s.length()){
                char rChar = s.charAt(r);
                if(ch1 == rChar || ch2 == rChar){
                    tempMap.put(rChar, tempMap.getOrDefault(rChar, 0) + 1);
                }

                while(tempMap.get(ch1) != null && tempMap.get(ch2) != null && tempMap.get(ch1) >= count1 && tempMap.get(ch2) >= count2){
                    char lChar = s.charAt(l);
                    ans = Math.min(ans , r-l+1);
                    if(ch1 == lChar || ch2 == lChar){
                        tempMap.put(lChar, tempMap.getOrDefault(lChar, 0) - 1);
                    }
                    l++;
                }
                r++;
            }
        }else {
            //String s = "QQWQRRWRRQWWEWRQEREWQQWQREWRWQRQRWRQEQWE"; //2Q1R1W
            char ch1 = (char)chMap.keySet().toArray()[0];
            char ch2 = (char)chMap.keySet().toArray()[1];
            char ch3 = (char)chMap.keySet().toArray()[2];
            Integer count1 = chMap.get(ch1);
            Integer count2 = chMap.get(ch2);
            Integer count3 = chMap.get(ch3);

            int l = 0, r = 0;
            HashMap<Character, Integer> tempMap = new HashMap<>();
            while(r < s.length()){
                char rChar = s.charAt(r);
                if(ch1 == rChar || ch2 == rChar || ch3 == rChar){
                    tempMap.put(rChar, tempMap.getOrDefault(rChar, 0) + 1);
                }

                while(tempMap.get(ch1) != null && tempMap.get(ch2) != null && tempMap.get(ch3) != null && tempMap.get(ch1) >= count1 && tempMap.get(ch2) >= count2 && tempMap.get(ch3) >= count3){
                    char lChar = s.charAt(l);
                    ans = Math.min(ans , r-l+1);
                    if(ch1 == lChar || ch2 == lChar || ch3 == lChar){
                        tempMap.put(lChar, tempMap.getOrDefault(lChar, 0) - 1);
                    }
                    l++;
                }
                r++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "QQWQRRWRRQWWEWRQEREWQQWQREWRWQRQRWRQEQWE"; //2Q1R1W
        int i = balancedString(s);
        System.out.println("i = " + i);
    }

}
