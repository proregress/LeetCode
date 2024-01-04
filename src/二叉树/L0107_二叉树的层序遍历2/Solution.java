package 二叉树.L0107_二叉树的层序遍历2;

import 二叉树.entity.TreeNode;

import java.util.*;

/**
        3
   9       20
        15    7
 原：[3] [9,20] [15,7]
 现：[15,7] [9,20] [3]
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return res;
        }

        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                TreeNode poll = queue.poll();
                list.add(poll.val);

                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
            res.add(list);
        }

        Collections.reverse(res);
        return res;

    }

}
