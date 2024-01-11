package 二叉树.basic3_在BT和BST中寻找元素;

import 二叉树.entity.TreeNode;

public class BasicIsInTree {
    /**
     * 判断某元素是否在一棵二叉树内
     */
    boolean isInTree(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;

        return isInTree(root.left, target) || isInTree(root.right, target);
    }


    /**
     * 判断某元素是否在一棵二叉搜索树内
     * 增加二叉树左小又大的性质
     */
    boolean isInBST(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;

        if(root.val > target )
            return isInBST(root.left, target);
        if(root.val < target )
            return isInBST(root.right, target);

        return false;
    }

    /**
     * 针对BST的遍历框架
     */
    void BST(TreeNode root, int target){
        if(root == null) return;
        if(root.val == target) {
            //找到目标，做点什么}
        }
        if(root.val > target)
            BST(root.left, target);
        if(root.val < target)
                BST(root.right, target);
    }

}
