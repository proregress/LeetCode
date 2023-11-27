package 二叉树.basic;

import 二叉树.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PreorderTraverse {

    class Solution{
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            if(root == null){
                return res;
            }

            res.add(root.val);
            res.addAll(preorderTraversal(root.left));
            res.addAll(preorderTraversal(root.right));
            return res;

        }

    }

}

