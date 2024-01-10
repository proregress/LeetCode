package 二叉树.L0230_二叉搜索树中第k小的元素;

import 二叉树.entity.TreeNode;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        TreeNode leftRight = new TreeNode();
        root.val = 3;
        left.val = 1;
        right.val = 4;
        leftRight.val = 2;
        root.left = left;
        root.right = right;
        left.right = leftRight;

        int i = kthSmallest(root, 1);

        System.out.println("res = " + i);
    }

    static LinkedList<Integer> res = new LinkedList<Integer>();
    public static int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return res.get(k-1);

    }

    private static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
