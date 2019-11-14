package will.zhang.UsingLinkedList.RemoveDuplicatesFromSortedList83;
/**
  * @author will.zjw
  * @date 2019-11-14 15:20
  */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            while (next != null && cur.val == next.val) {
                cur.next = next.next;
                next.next = null;
                next = cur.next;
            }

            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution solution = new Solution();
        ListNode listNode = solution.deleteDuplicates(node1);

        ListNode cur = listNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
