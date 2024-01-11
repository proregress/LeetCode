package 二叉树.L0700_二叉搜索树中的搜索;

import 二叉树.entity.TreeNode;

public class Slution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(root.val > val){
            return searchBST(root.left, val);
        }
        if(root.val < val){
            return searchBST(root.right, val);
        }
        return null;
    }

}
