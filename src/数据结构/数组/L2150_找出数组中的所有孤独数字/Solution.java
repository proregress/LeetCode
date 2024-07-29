package 数据结构.数组.L2150_找出数组中的所有孤独数字;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            set.add(i);
            map.put(i , map.getOrDefault(i, 0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == 1 && !set.contains(key-1) && !set.contains(key+1)){
                list.add(key);
            }
        }
        return list;
    }
}
