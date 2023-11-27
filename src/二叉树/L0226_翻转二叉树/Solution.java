package 二叉树.L0226_翻转二叉树;


import 二叉树.entity.TreeNode;

class Solution {
    //对于树root来说，将其反转，等同于将其左子树与右子树对调
    public TreeNode invertTree(TreeNode root) {
        TreeNode treeNode = new TreeNode();
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);//将左子树反转
        TreeNode right = invertTree(root.right);//将左子树反转
        //再将左右子树对调
        treeNode.val = root.val;
        treeNode.left = right;
        treeNode.right = left;
        return treeNode;

    }
}

