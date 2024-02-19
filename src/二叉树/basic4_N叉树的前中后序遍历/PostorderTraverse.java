package 二叉树.basic4_N叉树的前中后序遍历;

import java.util.LinkedList;
import java.util.List;

public class PostorderTraverse {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }

        for(Node node : root.children){
            res.addAll(postorder(node));
        }
        res.add(root.val);
        return res;
    }
}

