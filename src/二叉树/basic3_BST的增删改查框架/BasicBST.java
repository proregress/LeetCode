package 二叉树.basic3_BST的增删改查框架;

import 二叉树.entity.TreeNode;

public class BasicBST {
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

    /**
     * BST插入新节点框架
     */
    TreeNode insertIntoBST(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
//        if(root.val == val){ } //BST一般不会插入已存在元素
        if(root.val > val){
            root.left = insertIntoBST(root.left,val);
        }
        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }

    /**
     * 在BST中删除一个数的框架
     */
    TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return null;
        if(root.val == key){
            //找到，进行删除
            //情况1：root没有子节点
            if(root.left == null && root.right == null) return null;
            //情况2：root只有一个子节点
            if(root.left == null )return root.right;
            if(root.right == null )return root.left;
            //情况3：root两个子节点都要，那么：找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己。此处以后者为例
//            if(root.left != null && root.right != null){
            //找到右子树中最小的节点
            TreeNode minNode = getMin(root.right);
            // 把 root 改成 minNode
            root.val = minNode.val;
            // 转而去删除 minNode
            root.right = deleteNode(root.right, minNode.val);
//            }
        }else if(root.val > key){
            //去左子树找
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            //去右子树找
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    /**
     * 得到二叉搜索树中的最小节点
     * @param node
     * @return
     */
    TreeNode getMin(TreeNode node){
        //BST 最左边的就是最小的
        while(node.left != null) node = node.left;
        return node;
    }

}
