package will.zhang.SwordTowardsOffer.GetKthFromEnd22;

/**
 * @author will
 */
public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        for (int i = 1; i < k; i++) {
            if (p.next != null) {
                p = p.next;
            } else {
                return null;
            }
        }

        ListNode p2 = head;

        while (p.next != null) {
            p = p.next;
            p2 = p2.next;
        }

        return p2;
    }

    public static void main(String[] args) {
        ListNode listNode  = null;
        ListNode result = new Solution().getKthFromEnd(listNode, 2);
        System.out.println(result);

        listNode  = ListNode.create(new int[]{1, 2, 3, 4, 5});
        result = new Solution().getKthFromEnd(listNode, 2);
        System.out.println(result);

        listNode  = ListNode.create(new int[]{1, 2, 3, 4, 5});
        result = new Solution().getKthFromEnd(listNode, 8);
        System.out.println(result);
    }
}
