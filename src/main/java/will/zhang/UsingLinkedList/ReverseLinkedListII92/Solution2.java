package will.zhang.UsingLinkedList.ReverseLinkedListII92;

import will.zhang.util.ListNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/17
 */
public class Solution2 {

    private ListNode successor;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode theNthNode = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return theNthNode;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create(new int[]{1, 2, 3, 4, 5, 6});
        ListNode result = new Solution2().reverseBetween(listNode, 3, 5);
        System.out.println(result);
    }
}
