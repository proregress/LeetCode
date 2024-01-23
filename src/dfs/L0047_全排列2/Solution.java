package dfs.L0047_全排列2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xufan
 * @since 2024/01/23 21:22
 */

public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums){
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && used[i-1]){
                continue;
            }
            used[i] = true;
            track.add(nums[i]);
            dfs(nums);
            track.removeLast();
            used[i] = false;
        }
    }
}
