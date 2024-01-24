package dfs.子集_排列_组合.L0078_子集;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start){
        res.add(new LinkedList<>(track));

        for(int i = start; i < nums.length; i++){
            //做出选择
            track.addLast(nums[i]);
            dfs(nums, i+1);
            //撤销选择
            track.removeLast();
        }

    }
}
