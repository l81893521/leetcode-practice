package will.zhang.UsingLinkedList.ReverseNodesInKGroup25;
/**
  * @author will.zjw
  * @date 2019-11-20 16:14
  */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode end = dummyHead;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummyHead.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        ListNode listNode = ListNode.create(arr1);

        Solution solution = new Solution();
        listNode = solution.reverseKGroup(listNode, 2);

        ListNode cur = listNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
