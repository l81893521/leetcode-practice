package will.zhang.UsingLinkedList.RemoveNthFromEnd19;

/**
 * @author will
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode p = head;

        for (int i = 0; i < n; i++) {
            if (p.next != null) {
                p = p.next;
            } else if ((n - i) > 1) { //p.next == null && n > size
                return null;
            } else if ((n - i) == 1) { //p.next == null && n = size : remove first one
                return head.next;
            }
        }

        ListNode p2 = head;

        while (p != null && p.next != null) {
            p = p.next;
            p2 = p2.next;
        }

        ListNode delNode = p2.next;
        p2.next = delNode.next;
        delNode.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = null;
        ListNode result = new Solution().removeNthFromEnd(listNode, 1);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});
        result = new Solution().removeNthFromEnd(listNode, 2);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1});
        result = new Solution().removeNthFromEnd(listNode, 1);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2});
        result = new Solution().removeNthFromEnd(listNode, 1);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2});
        result = new Solution().removeNthFromEnd(listNode, 2);
        System.out.println(result);
    }
}
