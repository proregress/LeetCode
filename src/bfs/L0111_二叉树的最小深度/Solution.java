package bfs.L0111_二叉树的最小深度;

import 二叉树.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int minDepth = 1;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode poll = queue.poll();
                if(poll.left == null && poll.right == null) return minDepth;
                if(poll.right != null) queue.offer(poll.right);
                if(poll.left != null) queue.offer(poll.left);
            }
            minDepth++;
        }

        return minDepth;
    }
}
