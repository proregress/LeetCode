package 二叉树.L0111_二叉树的最小深度;

import 二叉树.entity.TreeNode;

/**
 （1）原本没有写root.left 和root.right 为null的情况，一提交就报错：一个只有单侧子树的树，返回值为1，实际为5，思考原因，很快发现需要考虑单侧子树为空的情况，
 如果某侧子树为空，则minDepth应该是另一侧子树的深度有关。

 （2）于是直接返回traverse(root.left) 和 traverse(root.right), 还是错误
 此时灵光一现，思考traverse()这个函数做的是什么，做的是迭代某棵树，返回这棵树的最小深度。
 那么traverse(root.left)返回的是左子树的最小深度，traverse(root.right)返回的是右子树的最小深度，那么作为整棵树的返回值，应该要+1，
 于是补上+1，正确通过。
 */
public class Solution {
    public int minDepth(TreeNode root) {
        return traverse(root);
    }

    /**
     * 灵光一现的原因：
     *
     *
     */
    private Integer traverse(TreeNode root){
        if(root == null){
            return 0;
        }
        if (root.left == null){
            return traverse(root.right) + 1; //这里灵光一现，写上了+1，就正确通过了
        }
        if(root.right == null){
            return traverse(root.left) + 1; //这里灵光一现，写上了+1，就正确通过了
        }
        Integer left = traverse(root.left);
        Integer right = traverse(root.right);
        Integer mindepth = Math.min(left, right) + 1;

        return mindepth;

    }
}
