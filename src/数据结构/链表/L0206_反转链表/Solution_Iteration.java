package 数据结构.链表.L0206_反转链表;

import entity.ListNode;


/**
 * 迭代
 */
public class Solution_Iteration {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;

        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
