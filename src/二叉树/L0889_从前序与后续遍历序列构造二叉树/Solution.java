package 二叉树.L0889_从前序与后续遍历序列构造二叉树;

import 二叉树.entity.TreeNode;

class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder,0, preorder.length-1,
                    postorder,0, postorder.length-1);
    }

    private TreeNode build(int[] preorder,int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if(preStart > preEnd ){
            return null;
        }
        if(preStart == preEnd){
            TreeNode treeNode = new TreeNode();
            treeNode.val = preorder[preStart];
            return treeNode;
        }
        if(postStart > postEnd){
            return null;
        }
        //从前序与后续无法构造唯一二叉树，因此我设定preOrder的根节点的右边节点就是左子树的根节点
        int val = preorder[preStart];
        TreeNode root = new TreeNode();
        root.val = val;

        int leftRootVal = preorder[preStart + 1]; //左子树的根节点的值
        //在postOrder中找到该值的index
        int index = 0;
        for(int i = 0; i < postorder.length; i++){
            if(postorder[i] == leftRootVal){
                index = i;
            }
        }

        int leftSize = index - postStart + 1;

        root.left = build(preorder,preStart+1,preStart+leftSize,postorder,postStart,index);
        root.right = build(preorder,preStart+leftSize+1,preEnd,postorder,index+1,postEnd-1);

        return root;
    }
}
