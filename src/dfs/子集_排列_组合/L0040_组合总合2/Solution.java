package dfs.子集_排列_组合.L0040_组合总合2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 【剪枝】
 */
/*
输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:[[1,1,6],[1,2,5],[1,7],[2,6]]

输入: candidates = [2,5,2,1,2], target = 5
输出:[[1,2,2],[5]]

 */
public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int sum, int start){
        if(sum == target){
            // 如果在这里用contains判断，时间复杂度会超，只能使用剪枝
            res.add(new LinkedList<>(track));
            return;
        }
        if(track.size() == candidates.length || sum > target){
            return;
        }
        for(int i = start; i < candidates.length; i++){
            //剪枝操作，大大提升时间复杂度
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            sum = sum + candidates[i];
            track.add(candidates[i]);
            dfs(candidates, target, sum, i+1);
            sum = sum - candidates[i];
            track.removeLast();
        }


    }
}
