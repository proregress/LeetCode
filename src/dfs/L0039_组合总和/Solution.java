package dfs.L0039_组合总和;

import java.util.LinkedList;
import java.util.List;

/*
输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]

思考：同样需要一个start变量来控制子集不重复
      但是i不+1来使得每个元素可以重复使用
 */
public class Solution {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        int target = 8;

        combinationSum(candidates, 8);

        System.out.println(res);
    }

    static List<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> track = new LinkedList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,0,target, 0);
        return res;
    }

    private static void dfs(int[] cadidates, int sum, int target, int start){
        if(sum == target){
            res.add(new LinkedList<>(track));
            return;
        }
        //track.size() == cadidates.length的判断不对，根本不需要这个判断，每个数字可以无限制重复使用
        /*if( track.size() == cadidates.length || sum > target){
            return;
        }*/
        if( sum > target){
            return;
        }
        for(int i = start; i < cadidates.length; i++){
            track.add(cadidates[i]);
            sum = sum + cadidates[i];
            dfs(cadidates,sum, target, i);
            track.removeLast();
            sum = sum -cadidates[i];
        }

    }
}
