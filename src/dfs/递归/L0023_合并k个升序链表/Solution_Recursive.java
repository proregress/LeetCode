package dfs.递归.L0023_合并k个升序链表;

import entity.ListNode;

public class Solution_Recursive {
    public static void main(String[] args) {
        //[[2],[],[-1]]
        ListNode l1 = new ListNode(2);
        ListNode l2 = null;
        ListNode l3 = new ListNode(-1);
        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        ListNode ans = mergeKLists(lists);
        System.out.println("ans = " + ans);
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null;
        for(int i = 0 ; i < lists.length; i++){
            root = merge2Lists(root, lists[i]);
        }

        return root;
    }

    public static ListNode merge2Lists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        ListNode root;
        if(l1.val <= l2.val){
            root = l1;
            root.next = merge2Lists(l1.next, l2);
        }else {
            root = l2;
            root.next = merge2Lists(l1, l2.next);
        }
        return root;
    }

}
