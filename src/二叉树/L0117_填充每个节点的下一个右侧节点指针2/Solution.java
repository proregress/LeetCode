package 二叉树.L0117_填充每个节点的下一个右侧节点指针2;

import 二叉树.entity.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
        1
   2       3
 4  5       7
 */
/**
 * 层序遍历
 */
public class Solution {
    public static void main(String[] args) {
        Node root = new Node();
        Node left = new Node();
        Node leftLeft = new Node();
        Node leftRight = new Node();
        Node right = new Node();
        Node rightRight = new Node();
        root.val = 1;
        left.val = 2;
        right.val = 3;
        leftLeft.val = 4;
        leftRight.val = 5;
        rightRight.val = 7;
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.right = rightRight;

        Node connect = connect(root);
        System.out.println("connect = " + connect);
    }

    public static Node connect(Node root) {
        if(root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                Node poll = queue.poll();
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
                if(i < size-1){
                    poll.next = queue.peek();
                }
            }
        }
        return root;
    }

}
