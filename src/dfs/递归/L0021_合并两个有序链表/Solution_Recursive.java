package dfs.递归.L0021_合并两个有序链表;

import entity.ListNode;

/**
 * 递归解法
 *
 * @author xufan
 * @since 2024/07/23 23:31
 */
public class Solution_Recursive {
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
        if(list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }

        ListNode root;
        if(list1.val <= list2.val){
            root = list1;
            root.next = mergeTwoLists(list1.next,list2);
        }else {
            root = list2;
            root.next = mergeTwoLists(list1, list2.next);
        }

        return root;
    }
}
