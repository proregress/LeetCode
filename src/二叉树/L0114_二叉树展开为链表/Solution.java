package 二叉树.L0114_二叉树展开为链表;

import 二叉树.entity.TreeNode;

class Solution {
    // 定义：输入节点 root，然后 root 为根的二叉树就会被拉平为一条链表
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // root的左子树使用flatten拉成链表，变成2-null-3-null-4
        flatten(root.left);
        // root的右子树使用flatten拉成链表，变成5-null-6
        flatten(root.right);

        // 1、得到拉平后的左右子树
        TreeNode left = root.left;
        TreeNode right = root.right;

        /*  *//**** 先把左子树移动右边，再将原左树接到后面就是正确的 ****//*
            // 2、将左子树作为右子树
            root.right = left;
            root.left = null;
            // 3、将原先的右子树接到当前右子树的末端
            TreeNode p = root;
            while(p.right != null){
                p = p.right;
            }
            p.right = right;*/


        /**** 先把右树移到左边的末端，再整体移到root的右边 ****/
        TreeNode q = left;
        if (q != null) {
            while (q.right != null) {
                q = q.right;
            }
            q.right = right;
        }

        // 再将当前左子树换到右边，然后左边置为null
        root.right = left;
        root.left = null;

    }
}

