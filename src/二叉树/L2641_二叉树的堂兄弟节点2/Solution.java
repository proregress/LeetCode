package 二叉树.L2641_二叉树的堂兄弟节点2;

import 二叉树.entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(9);
        TreeNode leftleft = new TreeNode(1);
        TreeNode leftright = new TreeNode(10);
        TreeNode rightright = new TreeNode(7);
        root.left = left;
        root.right = right;
        left.left = leftleft;
        left.right = leftright;
        right.right = rightright;

        TreeNode treeNode = replaceValueInTree(root);
        System.out.println("treeNode = " + treeNode);
    }
    /**
     * 思路： 层序遍历，可以得到每一层的和sum，然后堂兄弟的和就是sum-自己.value-兄弟.value
     */
    public static TreeNode replaceValueInTree(TreeNode root) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int sum = 0;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode poll = queue.poll();
                sum = sum + poll.val; //循环结束后可以得到这一层的和
                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
            sumMap.put(depth, sum);
            depth++;
        }

        queue.offer(root);
        depth = 0;
        root.val = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode poll = queue.poll();
                if(poll.left != null && poll.right != null){
                    Integer leftVal = poll.left.val;
                    Integer rightVal = poll.right.val;
                    poll.left.val = sumMap.get(depth+1) - leftVal - rightVal;
                    poll.right.val = sumMap.get(depth+1) - leftVal - rightVal;
                } else if (poll.left == null && poll.right == null){
                    continue;
                }else if (poll.left == null){
                    Integer val = poll.right.val;
                    poll.right.val = sumMap.get(depth+1) - val;
                } else if(poll.right == null){
                    Integer val = poll.left.val;
                    poll.left.val = sumMap.get(depth+1) - val;
                }

                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
            depth++;
        }
        return root;
    }

}
