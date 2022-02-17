package will.zhang.UsingLinkedList.ReverseLinkedListII92;

import will.zhang.util.ListNode;

/**
  * @author will.zjw
  * @date 2019-11-13 20:36
  */
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;

        int startIndex = 1;
        while (cur != null) {
            if (startIndex == m && m != n) {
                ListNode start = cur;
                ListNode end = cur;
                for (; startIndex < n; startIndex++) {
                    end = end.next;
                }
                if (end == null) {
                    break;
                }
                ListNode next = end.next;
                end.next = null;
                pre.next = reverse(start);
                start.next = next;

                cur = start.next;
            } else {
                startIndex++;
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    private ListNode reverse(ListNode listNode) {
        ListNode pre = null;
        ListNode cur = listNode;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});

        ListNode reverseNode = new Solution().reverseBetween(listNode, 2, 5);
        System.out.println(reverseNode);
    }
}
