package sort.customSorting.L0819_最常见的单词;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "Bob. hIt, baLl";
        String[] banned = {"hit","bob"};
        String ans = mostCommonWord(s,banned);
        System.out.println("ans = " + ans);
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        // 注意split用法
        String[] split = paragraph.split("[!?',;. ]");
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(String s : banned){
            set.add(s.toLowerCase());
        }
        for(String str : split){
            str = str.trim().toLowerCase();
            // 要排除空串
            if(set.contains(str) || str.equals("") || str == "") continue;
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            list.add(key);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        return list.get(0);
    }
}
