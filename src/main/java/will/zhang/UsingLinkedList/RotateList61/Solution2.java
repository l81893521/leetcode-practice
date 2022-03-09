package will.zhang.UsingLinkedList.RotateList61;

import will.zhang.util.ListNode;

/**
 * @author will
 */
public class Solution2 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode lo = dummy;
        ListNode hi = dummy;

        int i = 0;
        while (hi.next != null) {
            hi = hi.next;
            i++;
        }

        int keepGoing = k % i;
        if (keepGoing == 0) {
            return head;
        }

        hi = dummy;
        for (int j = 0; j < keepGoing; j++) {
            hi = hi.next;
        }

        while(hi.next != null) {
            hi = hi.next;
            lo = lo.next;
        }

        ListNode newHead = lo.next;
        hi.next = dummy.next;
        lo.next = null;

        return newHead;
    }
}
