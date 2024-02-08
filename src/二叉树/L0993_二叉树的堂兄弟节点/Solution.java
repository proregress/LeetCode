package 二叉树.L0993_二叉树的堂兄弟节点;

import 二叉树.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftleft = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.left = leftleft;
        isCousins(root, 3,4);
        System.out.println();
    }

    /**
     * 层序遍历 bfs
     */
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y){
            return false;
        }

        LinkedList<Integer> list ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ((!queue.isEmpty())){
            int size = queue.size();
            list = new LinkedList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode poll = queue.poll();
                if(poll.left != null && poll.right != null){
                    if( (poll.left.val == x && poll.right.val == y) || (poll.left.val == y && poll.right.val == x)) return false;
                }
                if(poll.left != null) {
                    list.add(poll.left.val);
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    list.add(poll.right.val);
                    queue.offer(poll.right);
                }
            }
            if(list.contains(x) && list.contains(y)){
                return true;
            }
        }
        return false;
    }

}
