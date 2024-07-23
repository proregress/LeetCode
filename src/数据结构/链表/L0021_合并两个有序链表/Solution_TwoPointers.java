package 数据结构.链表.L0021_合并两个有序链表;

import entity.ListNode;

/**
 * @author xufan
 * @since 2024/07/23 21:56
 */

public class Solution_TwoPointers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l111 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l222 = new ListNode(4);
        l1.next = l11;
        l11.next = l111;
        l2.next = l22;
        l22.next = l222;
        ListNode root = mergeTwoLists(l1, l2);
        System.out.println("root = " + root);

    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode pre = new ListNode();
        ListNode root = pre;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                pre.next = list1;
                list1 = list1.next;
            }else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return root.next;
    }
}
