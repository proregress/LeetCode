package 二叉树.L0652_寻找重复子树;

import 二叉树.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    List<TreeNode> list = new ArrayList<>();
    Map<String,Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);

        return list;
    }

    private String traverse(TreeNode root){
        if(root == null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subtree = left + "," + right + "," + root.val;

        Integer freq = map.getOrDefault(subtree, 0);
        if(freq == 1){
            list.add(root);
        }
        map.put(subtree,freq+1);
        return subtree;
    }
}
