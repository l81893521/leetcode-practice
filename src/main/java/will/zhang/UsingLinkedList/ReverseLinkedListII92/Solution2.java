package will.zhang.UsingLinkedList.ReverseLinkedListII92;

import will.zhang.util.ListNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/17
 */
public class Solution2 {

    private ListNode successor;

    public ListNode reverseBetween(ListNode head, int m, int n) {

    }

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode theNthNode = reverseN(head.next, n - 1);
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});
        ListNode result = new Solution2().reverseN(listNode, 3);
        System.out.println(result);
    }
}
