package 二叉树.L0103_二叉树的锯齿形层序遍历;

import 二叉树.entity.TreeNode;

import java.util.*;

/**
            3
        9       20
             15    7
 */

/**
 * 严格按照zigzag的方式遍历：
 * 使用双端队列deque
 */
public class Solution2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        TreeNode rightLeft = new TreeNode();
        TreeNode rightRight = new TreeNode();
        root.val = 3;
        left.val = 9;
        right.val = 20;
        rightLeft.val = 15;
        rightRight.val = 7;
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;

        List<List<Integer>> res = zigzagLevelOrder(root);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null){
            return res;
        }

        deque.offerLast(root);
        boolean flag = true;
        while(!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for(int i = 0; i < size ; i++){
                if(flag){
                    //从左往右
                    TreeNode pollFirst = deque.pollFirst();
                    list.add(pollFirst.val);
                    if(pollFirst.left != null){
                        deque.offerLast(pollFirst.left);
                    }
                    if(pollFirst.right != null){
                        deque.offerLast(pollFirst.right);
                    }
                }else {
                    //从右往左
                    TreeNode pollLast = deque.pollLast();
                    list.add(pollLast.val);
                    if(pollLast.right != null){
                        deque.offerFirst(pollLast.right);
                    }
                    if(pollLast.left != null){
                        deque.offerFirst(pollLast.left);
                    }
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}
