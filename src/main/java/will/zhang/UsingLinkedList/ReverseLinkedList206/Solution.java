package will.zhang.UsingLinkedList.ReverseLinkedList206;
/**
  * @author will.zjw
  * @date 2019-11-13 19:58
  */
public class Solution {

    public ListNode reverseList(ListNode head) {

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
        ListNode reverNode = solution.reverseList(node1);

        ListNode cur = reverNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}


