package 二叉树.L0222_完全二叉树的节点个数;

import 二叉树.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序遍历
 */
public class Solution {
    int res = 0;
    public int countNodes(TreeNode root) {
        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                TreeNode poll = queue.poll();
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
            res = res + size;
        }
        return res;
    }

}
