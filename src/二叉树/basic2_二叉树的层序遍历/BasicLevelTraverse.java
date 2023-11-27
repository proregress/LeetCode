package 二叉树.basic2_二叉树的层序遍历;

import 二叉树.entity.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BasicLevelTraverse {

    //二叉树的层序遍历
    void levelTraverse(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                Node poll = queue.poll();
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
    }
}

