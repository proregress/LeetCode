package 二叉树.L0105_从前序与中序遍历序列构造二叉树;

import 二叉树.entity.TreeNode;

public class Solution {
    public static void main(String[] args) {
        int[] preorder = new int[]{4,2,1,3,6,5,7};
        int[] inorder = new int[]{1,2,3,4,5,6,7};
//        TreeNode treeNode = buildTree(preorder, inorder);
//        System.out.println(treeNode);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder,int preStart, int preEnd, int[] inorder,int inStart, int inEnd){
        if(preStart > preEnd){
            return null;
        }
        if(inStart > inEnd){
            return null;
        }

        int rootVal = preorder[preStart];
        int index = -1; //获得根节点在中序遍历中的下标
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;

        TreeNode root = new TreeNode();
        root.val = rootVal;

        root.left = build(preorder,  preStart+1, preStart + leftSize, inorder, inStart, index-1);
        root.right = build(preorder, preStart+leftSize+1, preEnd, inorder,index+1, inEnd);

        return root;
    }
}










