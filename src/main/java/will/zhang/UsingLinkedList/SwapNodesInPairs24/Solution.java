package will.zhang.UsingLinkedList.SwapNodesInPairs24;

import will.zhang.util.ListNode;

/**
  * @author will.zjw
  * @date 2019-11-14 20:25
  */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode next = p.next.next.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 4, 3, 5};
        ListNode node1 = ListNode.create(arr1);

        ListNode listNode = new Solution().swapPairs(node1);
        System.out.println(listNode);
    }
}
