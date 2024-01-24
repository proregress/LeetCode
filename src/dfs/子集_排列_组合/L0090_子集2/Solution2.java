package dfs.子集_排列_组合.L0090_子集2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剪枝
 */
public class Solution2 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }
    private void dfs(int[] nums, int start){

        res.add(new LinkedList<>(track));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            track.addLast(nums[i]);
            dfs(nums, i + 1);
            track.removeLast();
        }

    }
}
