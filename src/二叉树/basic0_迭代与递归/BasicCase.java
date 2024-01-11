package 二叉树.basic0_迭代与递归;

public class BasicCase {

    /**
     * 迭代遍历数组1
     */
    public static void traverse1(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /**
     * 迭代遍历数组2
     */
    public static void traverse2(Integer[] arr) {
        for (Integer i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }

    /**
     * 递归遍历数组
     */
    public static void traverse3(Integer[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        System.out.print(arr[i]);
        traverse3(arr, i + 1);
    }

    /**
     * 迭代遍历单链表
     */
    public static void traverse4(ListNode head) {
        for (ListNode node = head; node != null; node = node.next){
            System.out.print(node.data);
        }
        System.out.println();
    }

    /**
     * 递归遍历单链表-顺序
     */
    public static void traverse5(ListNode head) {
        if(head == null){
            return;
        }
        System.out.print(head.data); //前序
        traverse5(head.next);

    }

    /**
     * 递归遍历单链表-倒序
     */
    public static void traverse6(ListNode head) {
        if(head == null){
            return;
        }
        traverse6(head.next);
        System.out.print(head.data);//后序

    }

    public static void main(String[] args) {
        //数组遍历
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        traverse1(arr);
        traverse2(arr);
        traverse3(arr, 0);
        System.out.println();
        System.out.println();

        //链表遍历
        ListNode head = node();
        traverse4(head);
        System.out.println();
        traverse5(head);
        System.out.println();
        traverse6(head);
    }

    /**
     * 定义一个单链表并放入数据
     */
    private static ListNode node() {

        ListNode node6 = new ListNode(6,null);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        return node1;
    }

    static class ListNode {
        Integer data;
        ListNode next;

        public ListNode() {

        }

        public ListNode(Integer data) {
            this.data = data;
        }

        public ListNode(Integer data, ListNode next) {
            this.data = data;
            this.next = next;
        }

    }
}
