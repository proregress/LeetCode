package 二叉树.L0538_把二叉搜索树转化为累加树;

import 二叉树.entity.TreeNode;

/**
 *
 * 改进：使用一次递归
 * @author xufan
 * @since 2024/01/10 20:50
 */

public class Solution2 {
    static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    private static void inorder(TreeNode root){

        if(root == null){
            return;
        }
        //先右后左，即倒序排列
        inorder(root.right);
        sum = sum + root.val;
        root.val = sum;
        inorder(root.left);

    }
}
