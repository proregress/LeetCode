package twoPointers.L0141_环形链表;

import entity.ListNode;

public class Solution {
    /**
     * 快慢指针，如果成环，则slow每走一步fast走两步的情况下，最后一定会达到同一个节点，因为套圈了
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
