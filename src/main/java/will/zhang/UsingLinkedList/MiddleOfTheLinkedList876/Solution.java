package will.zhang.UsingLinkedList.MiddleOfTheLinkedList876;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/16
 */
public class Solution {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            //slow move 1 step
            slow = slow.next;
            //fast move 2 step
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create(new int[]{1, 2});
        ListNode result = new Solution().middleNode(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 3});
        result = new Solution().middleNode(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 3, 4});
        result = new Solution().middleNode(listNode);
        System.out.println(result);
    }
}
