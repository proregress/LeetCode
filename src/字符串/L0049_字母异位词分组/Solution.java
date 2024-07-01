package 字符串.L0049_字母异位词分组;

import java.util.*;

/**
 * dfs超时
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> lists = map.getOrDefault(key, new ArrayList<>());
            lists.add(str);
            map.put(key,lists);
        }
        for(List<String> list : map.values()){
            resultList.add(list);
        }
        return resultList;
    }


}
