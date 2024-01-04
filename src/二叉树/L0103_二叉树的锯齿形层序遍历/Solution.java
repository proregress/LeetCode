package 二叉树.L0103_二叉树的锯齿形层序遍历;

import 二叉树.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
               1
       2               3
   4      5       6       7
 8  9  10  11  12  13  14  15

 原：    [1] [2,3] [4,5,6,7] [8,9,10,11,12,13,14,15]
 zigzag: [1] [3,2] [4,5,6,7] [15,14,13,12,11,10,9,8]
 */

/**
 * 解法一：
 * 层序遍历，然后奇数下标数组倒序排列
 */
public class Solution {
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
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
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

        for(int i = 0; i < res.size(); i++){
            if(i % 2 == 1){
                List<Integer> newlist = new ArrayList<>();
                List<Integer> oldlist = res.get(i);
                for(int j = oldlist.size()-1; j >= 0; j--){
                    newlist.add(oldlist.get(j));
                }
                res.remove(i);
                res.add(i,newlist);
            }
        }

        return res;
    }

}
