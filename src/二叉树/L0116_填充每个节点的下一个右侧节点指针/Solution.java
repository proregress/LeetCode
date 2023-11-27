package 二叉树.L0116_填充每个节点的下一个右侧节点指针;

import 二叉树.entity.Node;

import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public Node connect(Node root) {
        //二叉树的层序遍历
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }

                if (i < size - 1) {
                    poll.next = queue.peek();
                }
            }
        }
        return root;
    }

}
