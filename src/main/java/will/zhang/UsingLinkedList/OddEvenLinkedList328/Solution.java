package will.zhang.UsingLinkedList.OddEvenLinkedList328;

/**
  * @author will.zjw
  * @date 2019-11-14 15:44
  */
public class Solution {

    public ListNode oddEvenList(ListNode head) {

        ListNode cur = head;

        ListNode leftNode = new ListNode(0);
        ListNode rightNode = new ListNode(0);
        ListNode left = leftNode;
        ListNode right = rightNode;

        boolean oddEven = true;
        while (cur != null) {
            if (oddEven) {
                left.next = new ListNode(cur.val);
                left = left.next;
                oddEven = false;
            } else {
                right.next = new ListNode(cur.val);
                right = right.next;
                oddEven = true;
            }
            cur = cur.next;
        }
        left.next = rightNode.next;
        return leftNode.next;
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

        Solution
            solution = new Solution();
        ListNode reverseNode = solution.oddEvenList(node1);

        ListNode cur = reverseNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
