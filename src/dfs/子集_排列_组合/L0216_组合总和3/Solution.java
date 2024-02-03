package dfs.子集_排列_组合.L0216_组合总和3;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n, k, 0,1);
        return res;
    }

    private void dfs(int target, int k, int sum, int start){
        if(sum == target && track.size() == k){
            res.add(new LinkedList<>(track));
            return;
        }
        if(sum > target || track.size() >= k){
            return;
        }
        for(int i = start; i <= 9; i++){
            track.add(i);
            sum = sum + i;
            dfs(target, k, sum,i+1);
            track.removeLast();
            sum = sum - i ;
        }
    }
}
