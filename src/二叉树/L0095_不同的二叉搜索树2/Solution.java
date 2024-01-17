package 二叉树.L0095_不同的二叉搜索树2;

import 二叉树.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
不得不说，递归构造这部分实在是太抽象了
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();;
        return build(1, n);
    }

    private List<TreeNode> build(int low, int hi){

        List<TreeNode> res = new ArrayList<>();
        //base case的返回值总是不会写
        if(low > hi){
            res.add(null);
            return res;
        }

        for(int i = low; i <= hi; i++){
//            TreeNode root = new TreeNode(i); 这句话应该放在双层for循环里面
            List<TreeNode> leftList = build(low, i-1);
            List<TreeNode> rightList = build(i+1, hi);
            for(TreeNode left : leftList){
                for(TreeNode right : rightList){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;


    }

}
