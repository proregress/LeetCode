/***
题目考察有：
考察参赛者构建链表能力；
考察参赛者使用链表的能力。

违背本意的做法有：
不构建链表，使用其他容器;
倒序构建链表，为查找倒数第k个节点抄近路；
记住链表长度n，查找第n-k个节点。
但本题必须要(1)正序构建链表;(2)构建后要忘记链表长度。
***/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         // 1.输入内容
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            int n = sc.nextInt(); //链表长度
            ListNode headNode = new ListNode(-1); //定义表头
            ListNode temp = headNode;
            
            //定义表身——正序构建链表
            for(int i = 0; i < n; i++){
                int val = sc.nextInt();
                temp.nextNode = new ListNode(val); //存放着表头的temp节点，指向的下一个节点为新加入的节点
                temp = temp.nextNode; //接着又将temp自己指定为这个新加入的节点。这样在循环中，temp每次都先指向下一个新加入的节点，接着又转移至下一个节点，正序构建了链表
            }
            
            // 2.遍历倒数第k节点的指针
            //当前链表的长度为 n，则链表的倒数第 k 个节点即为正数第 n - k (index)个节点，此时我们只需要顺序遍历到链表的第 n - k个节点即为倒数第 k个节点。
            int k = sc.nextInt();
            for(int i = 0; i < n-k+1; i++){
                headNode = headNode.nextNode;
            }
            
            System.out.println(headNode.val);
        }
    }
}
class ListNode{
    int val;
    ListNode nextNode;
    
    public ListNode(Integer val){
        this.val = val;
        this.nextNode = null;
    }
}

