package bfs.L0101_对称二叉树;

import 二叉树.entity.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<LinkedList<Integer>> lists = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.right != null){
                    queue.offer(poll.right);
                    list.add(poll.right.val);
                }else if(poll.right == null){
                    list.add(-200);
                }
                if(poll.left != null){
                    queue.offer(poll.left);
                    list.add(poll.left.val);
                }else if(poll.left == null){
                    list.add(-200);
                }
            }
            lists.add(list);
        }

        for(LinkedList<Integer> list : lists){
            int size = list.size();
            List<Integer> left = list.subList(0, size / 2);
            List<Integer> right = list.subList(size / 2,size);
            Collections.reverse(right);
            for(int i = 0 ; i < left.size(); i++) {
                if(!left.get(i).equals(right.get(i))){
                    return false;
                }
            }
        }
        return true;
    }

}
