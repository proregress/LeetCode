package 数据结构.hashmap.L0594_最长和谐子序列;

import java.util.HashMap;

public class Solution {
    public int findLHS(int[] nums) {
        /**
         * hashmap存所有数字及其出现次数
         * 依次遍历map的key，获取key的值，和key-1的值，和key+1的值，求和比较大小
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int ans = Integer.MIN_VALUE;
        for(int key : map.keySet()){
            Integer i = map.get(key);
            Integer i1 = map.get(key - 1);
            Integer i2 = map.get(key + 1);
            if(i1 != null && i2 != null){
                ans = max(ans, i+i1, i+i2);
            }else if(i1 != null){
                ans = Math.max(ans, i+i1);
            }else if(i2 != null){
                ans = Math.max(ans, i+i2);
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    public int max(int a, int b, int c){
        return a > b ? Math.max(a,c) : Math.max(b,c);
    }
}
