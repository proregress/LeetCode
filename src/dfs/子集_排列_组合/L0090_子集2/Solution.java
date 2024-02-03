package dfs.子集_排列_组合.L0090_子集2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); //加上排序，再配合contains就行
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start){
        if(!res.contains(track)){   //在未给选择列表nums排序前，只判断这个是不够的
            res.add(new LinkedList<>(track));
        }
        for(int i = start; i < nums.length; i++){
            track.addLast(nums[i]);
            dfs(nums,i+1);
            track.removeLast();
        }

    }
}
