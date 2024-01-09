package 二叉树.L0331_验证二叉树的前序序列化;

import 二叉树.entity.TreeNode;

import java.util.LinkedList;

/**
 * 观察了一下，要判断是否能返回正确的一棵树，要看输入的字符串是否能对应到一棵树的各节点，
 * 如果不能，则会有多的字符遗留下来，因此用一个size变量来判断，每构建一个节点，size-1，等建成一棵树后，如果size不为0，则说明构建树出错。
 * 官方解答用的栈来判断，似乎是同一种思路。
 */
/*
由字符串构建成树的写法还不熟练
 */
public class Solution {
    int size = -1;
    public boolean isValidSerialization(String preorder) {
        LinkedList<String> list = new LinkedList<>();
        String[] split = preorder.split(",");
        for(String s : split){
            list.add(s);
        }
        size = split.length;

        build(list);
        if(size != 0){
            return false;
        }else{
            return true;
        }

    }

    private TreeNode build(LinkedList<String> list){
        size = size -1;
        if(list.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode();
        String val = list.removeFirst();
        if(val.equals("#")){
            return null;
        }
        root.val = Integer.parseInt(val);

        root.left = build(list);
        root.right = build(list);

        return root;

    }

}
