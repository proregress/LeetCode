package 二叉树.basic4_N叉树的前中后序遍历;

import java.util.LinkedList;
import java.util.List;

public class PreorderTraverse {
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
