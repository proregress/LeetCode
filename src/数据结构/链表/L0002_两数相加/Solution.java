package 数据结构.链表.L0002_两数相加;

import entity.ListNode;

import java.math.BigInteger;

/**
 * @author xufan
 * @since 2024/07/22 22:36
 */

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(9);
        ListNode l222 = new ListNode(9);
        ListNode l2222 = new ListNode(9);
        ListNode l22222 = new ListNode(9);
        ListNode l222222 = new ListNode(9);
        ListNode l2222222 = new ListNode(9);
        ListNode l22222222 = new ListNode(9);
        ListNode l222222222 = new ListNode(9);
        ListNode l2222222222 = new ListNode(9);
        l2.next = l22;
        l22.next = l222;
        l222.next = l2222;
        l2222.next = l22222;
        l22222.next = l222222;
        l222222.next = l2222222;
        l2222222.next = l22222222;
        l22222222.next = l222222222;
        l222222222.next = l2222222222;
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder i1 = new StringBuilder();
        StringBuilder i2 = new StringBuilder();
        while (l1 != null) {
            i1.insert(0,l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            i2.insert(0,l2.val);
            l2 = l2.next;
        }

        BigInteger b1 = new BigInteger(i1.toString());
        BigInteger b2 = new BigInteger(i2.toString());
        String number = String.valueOf(b1.add(b2));

        ListNode root = new ListNode(number.charAt(number.length()-1) - '0');
        ListNode ans = root;
        for(int i = number.length()-2; i >= 0; i--){
            ListNode node = new ListNode(number.charAt(i) - '0');
            ans.next = node;
            ans = ans.next;
        }

        return root;
    }

}
