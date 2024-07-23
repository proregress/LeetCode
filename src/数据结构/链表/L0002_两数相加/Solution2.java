package 数据结构.链表.L0002_两数相加;

import entity.ListNode;

/**
 * 加法器
 */
public class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode pre = root;
        int carry = 0;
        while(l1 != null || l2 != null){
            ListNode node;
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            if(sum >= 10){
                int mod = sum % 10;
                node = new ListNode(mod);
                carry = 1;
            }else {
                node = new ListNode(sum);
                carry = 0;
            }
            root.next = node;
            root = root.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0 ){
            ListNode node = new ListNode(carry);
            root.next = node;
        }
        return pre.next;
    }
}



























