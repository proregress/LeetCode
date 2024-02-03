package dfs.子集_排列_组合.L0077_组合;

import java.util.LinkedList;
import java.util.List;

/*
组合：
    与【子集】的相通之处在于，都与【全排列】不同，[1,2]与[2,1]是重复的，因此需要start这个变量，第一轮之后的数字1，不进入第二轮
 */
public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i = 1; i <= n; i++){
            nums[i-1] = i;
        }
        dfs(nums,0, k);
        return res;
    }

    private void dfs(int[] nums, int start,int k){
        if(track.size() == k){
            res.add(new LinkedList<>(track));
            return;
        }

        for(int i = start; i < nums.length; i++){
            track.addLast(nums[i]);
            dfs(nums,i+1, k);
            track.removeLast();
        }

    }
}
