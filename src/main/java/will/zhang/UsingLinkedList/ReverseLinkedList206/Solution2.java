package will.zhang.UsingLinkedList.ReverseLinkedList206;
/**
  * @author will.zjw
  * @date 2019-11-13 19:58
  */
public class Solution2 {

    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
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

        Solution2 solution = new Solution2();
        ListNode reverNode = solution.reverseList(node1);

        ListNode cur = reverNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}


