package will.zhang.UsingLinkedList.ReverseLinkedListII92;
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution solution = new Solution();
        ListNode reverseNode = solution.reverseBetween(node1, 2, 5);

        ListNode cur = reverseNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
