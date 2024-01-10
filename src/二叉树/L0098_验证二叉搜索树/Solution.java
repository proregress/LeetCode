package 二叉树.L0098_验证二叉搜索树;

import 二叉树.entity.TreeNode;

import java.util.LinkedList;

/**
 * 中序排列，验证大小
 * @author xufan
 * @since 2024/01/10 22:33
 */

public class Solution {
    LinkedList<Integer> list = new LinkedList<>();
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for(int i = 0 ; i < list.size()-1; i++){
            if(list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;

    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

}
