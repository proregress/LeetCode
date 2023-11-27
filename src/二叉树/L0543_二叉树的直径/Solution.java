package 二叉树.L0543_二叉树的直径;

import 二叉树.entity.TreeNode;

class Solution {
    int max = 0;

    //经过某节点的最长直径 = 左子节点的最长直径 + 右子节点的最长直径
    public int diameterOfBinaryTree(TreeNode root) {
        maxLenth(root);
        return max;

    }

    public int maxLenth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxLenth(root.left);
        int right = maxLenth(root.right);
        int temp = left + right;
        max = Math.max(temp, max);

        return Math.max(left, right) + 1;
    }

}
