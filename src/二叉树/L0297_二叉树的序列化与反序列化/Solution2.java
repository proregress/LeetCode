package 二叉树.L0297_二叉树的序列化与反序列化;

import 二叉树.entity.TreeNode;

import java.util.LinkedList;

/**
 * 后序遍历解法
 */
public class Solution2 {

    String sep = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        String[] split = data.split(sep);
        for(String s :split){
            list.add(s);
        }
        return build(list);
    }

    private void traverse(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(sep);
            return;
        }
        traverse(root.left, sb);
        traverse(root.right, sb);
        sb.append(root.val).append(sep);
    }

    private TreeNode build(LinkedList<String> list){
        if(list.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode();
        String last = list.removeLast();
        if(last.equals(NULL)){
            return null;
        }
        root.val = Integer.parseInt(last);
        root.right = build(list);
        root.left = build(list);

        return root;
    }

}
