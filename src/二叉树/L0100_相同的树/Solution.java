package 二叉树.L0100_相同的树;

import 二叉树.entity.TreeNode;

/**
 * 解法一：
 * 暴力解法，后序遍历分别得到两个二叉树的展开，然后比较两个展开是否相等。
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        String pTree = traverse(p);
        String qTree = traverse(q);

        if(pTree.equals(qTree)){
            return true;
        }else {
            return false;
        }

    }

    private String traverse(TreeNode root){
        if(root == null){
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subtree = left + "," + right + "," + root.val;
        return subtree;
    }
}
