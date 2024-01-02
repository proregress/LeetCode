package 二叉树.L0572_另一棵树的子树;

import 二叉树.entity.TreeNode;

/**
 * 暴力解法
 * 同样都是暴力解法，与100不同的是，这里需要在root.val后面再加一个”，“，否则测试用例root=[11],subRoot=[1] 就会出错，因为字符串分别是："#,#,11" 和 "#,#,1"。
 */
public class Solution {
    public static void main(String[] args) {

        TreeNode root = new TreeNode();
        root.val = 11;
        TreeNode subRoot = new TreeNode();
        subRoot.val = 1;

        boolean res = isSubtree(root, subRoot);
        System.out.println(res);

    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String tree = traverse(root);
        String subTree = traverse(subRoot);
        if(tree.contains(subTree)){
            return true;
        }else {
            return false;
        }
    }

    private static String traverse(TreeNode root){
        if(root == null){
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String tree =  left + "," + right + "," + root.val + ",";
        return tree;
    }
}
