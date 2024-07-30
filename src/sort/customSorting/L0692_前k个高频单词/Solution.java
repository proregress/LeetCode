package sort.customSorting.L0692_前k个高频单词;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s,0) + 1);
        }

        ArrayList<String> keys = new ArrayList<>();
        for(String key : map.keySet()){
            keys.add(key);
        }

        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o2) == map.get(o1)){
                    return o1.compareTo(o2);
                }
                return map.get(o2) - map.get(o1);
            }
        });

        return keys.subList(0,k);
    }
}
