package dfs.子集_排列_组合.L0046_全排列;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums){

        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            dfs(nums);
            track.removeLast();
        }
    }

}
