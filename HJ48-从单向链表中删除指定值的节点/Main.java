/***
好无语，为什么不能说人话这个题目
***/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) { 
            int num = sc.nextInt();  //总共num个节点
            int headValue = sc.nextInt();  //头节点值为headValue
            
            ListNode headNode = new ListNode(headValue); //构造出头节点，此时头节点的nextnode为空
            
            int i = 1;
            while(i <= (num-1)*2){
                int next = sc.nextInt();
                int pre = sc.nextInt(); // pre后面放next的值
                //临时遍历链表
                ListNode temp = headNode;
                //找到插入的位置
                while(temp.val != pre){
                    temp = temp.nextNode; 
                }
                //找到了，此时temp是pre，要在后面插入值为next的Node节点
                ListNode node = new ListNode(next);
                node.nextNode = temp.nextNode;
                temp.nextNode = node;
                i = i+2;   
            }
            
            int delNum = sc.nextInt();
            StringBuilder result = new StringBuilder();
            ListNode temp = headNode;
            while (temp != null) {   //注意此处，判断某节点是否为空，直接 node ？= null
                if (temp.val != delNum)
                    result.append(temp.val).append(" ");
                temp = temp.nextNode;//删除
            }
            // 注意要求每个数后面都加空格
            System.out.println(result.toString());
        }
    }
}

class ListNode{
    int val;
    ListNode nextNode;
    
    public ListNode(int val){
        this.val = val;
        nextNode = null;
    }
}
