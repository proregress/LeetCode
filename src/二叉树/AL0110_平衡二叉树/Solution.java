package 二叉树.AL0110_平衡二叉树;

import 二叉树.entity.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
        return  maxDepth(root) == -1 ? false : true;
    }

    private Integer maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        Integer left = maxDepth(root.left);
        if(left == -1){
            return -1;
        }
        Integer right = maxDepth(root.right);
        if(right == -1){
            return -1;
        }
        int abs = Math.abs(left - right);
        if(abs > 1){
            return -1;
        }else{
            return Math.max(left,right) + 1;
        }



    }
}
