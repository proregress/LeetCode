package 二叉树.L0098_验证二叉搜索树;

import 二叉树.entity.TreeNode;

/**
 * 优化，不需要全部遍历
 * @author xufan
 * @since 2024/01/10 22:47
 */

public class Solution2 {
    //todo ： [5,4,6,null,null,3,7]
    Boolean flag = true;
    // 这里是关键， Integer.MIN_VALUE, Double.MIN_VALUE都不行
    double min = -Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        Integer val = root.val;
        //注意小于等于而不是小于
        if(val <= min){
            flag = false;
        }
        min = val;
        inorder(root.right);
    }
}
