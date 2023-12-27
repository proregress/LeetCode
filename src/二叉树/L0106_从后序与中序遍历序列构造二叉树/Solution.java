package 二叉树.L0106_从后序与中序遍历序列构造二叉树;

import 二叉树.entity.TreeNode;
//test20231227
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1, postorder,0,postorder.length-1);
    }

    private TreeNode build(int[] inorder,int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        if (postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode();
        root.val = rootVal;

        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;
        root.left = build(inorder, inStart, index-1, postorder, postStart, postStart + leftSize-1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd-1);

        return root;
    }

    //new branch
}







