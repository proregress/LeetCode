package 二叉树.basic4_L0589_N叉树的前序遍历;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }

        res.add(root.val);
        for(Node node : root.children){
            res.addAll(preorder(node));
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
