package 二叉树.L0538_把二叉搜索树转化为累加树;

import 二叉树.entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
       3              7
    2    4   ->    9    4
 1               10
 */

/**
 * 应该属于暴力解法，根据规律，先中序排列，然后使用map将每个val 与 相加后的值一一对应， 然后再次递归，将val的值替换掉。
 */
public class Solution {
    static LinkedList<Integer> beforelist = new LinkedList<Integer>();
    static LinkedList<Integer> afterlist = new LinkedList<Integer>();
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        TreeNode leftLeft = new TreeNode();
        root.val = 3;
        left.val = 2;
        right.val = 4;
        leftLeft.val = 1;
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        Solution2.convertBST(root);

        System.out.println("map = " + map);
        System.out.println("beforelist = " + beforelist);
        System.out.println("afterlist = " + afterlist);
    }

    public static TreeNode convertBST(TreeNode root) {
        inorder(root);
        Integer first = 0;
        for(int i = beforelist.size()-1 ; i >= 0; i--){
            if(i == beforelist.size() -1){
                first = 0;
            }else{
                first = afterlist.getFirst();
            }
            afterlist.addFirst(beforelist.get(i) + first);
            map.put(beforelist.get(i), afterlist.getFirst());
        }

        replaceVal(root);
        return root;

    }

    private static void replaceVal(TreeNode root){
        if(root == null){
            return;
        }
        replaceVal(root.left);
        root.val = map.get(root.val);
        replaceVal(root.right);
    }

    private static void inorder(TreeNode root){
        if(root == null ){
            return;
        }
        inorder(root.left);
        beforelist.add(root.val);
        inorder(root.right);
    }
}
