package 二叉树.L0102_二叉树的层序遍历;

import 二叉树.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
