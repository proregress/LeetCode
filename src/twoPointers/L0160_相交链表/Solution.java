package twoPointers.L0160_相交链表;

import entity.ListNode;

public class Solution {
    /**
     * 双指针，一条链表走到尾后，开始走另一条链表，相当于两条链表一样长了，这时候判断两个结点是否相等就行
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA , p2 = headB;
        while (p1 !=  p2){
            if(p1 != null){
                p1 = p1.next;
            }else {
                p1 = headB;
            }

            if(p2 != null){
                p2 = p2.next;
            }else {
                p2 = headA;
            }
        }
        return p1;
    }
}
