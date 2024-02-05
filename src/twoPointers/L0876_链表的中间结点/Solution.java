package twoPointers.L0876_链表的中间结点;


import entity.ListNode;

public class Solution {
    /**
     * 快慢指针
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
