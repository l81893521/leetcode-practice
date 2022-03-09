package will.zhang.UsingLinkedList.RotateList61;

import will.zhang.util.ListNode;

/**
 * @author will
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if (head.next == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode lo = dummy;
        ListNode hi = dummy;
        for (int i = 0; i < k; i++) {
            if (hi.next == null) {
                hi = head;
            } else {
                hi = hi.next;
            }
        }

        while(hi.next != null) {
            lo = lo.next;
            hi = hi.next;
        }

        ListNode newHead = lo.next;
        if (newHead != dummy.next) {
            hi.next = dummy.next;
        }
        lo.next = null;

        return newHead;
    }

}
