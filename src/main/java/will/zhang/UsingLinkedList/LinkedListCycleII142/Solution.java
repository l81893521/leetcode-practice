package will.zhang.UsingLinkedList.LinkedListCycleII142;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/16
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast.next == null || fast.next.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = null;
        ListNode result = new Solution().detectCycle(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});
        result = new Solution().detectCycle(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});
        ListNode cycle = listNode.get(4);
        cycle.next = listNode.get(2);
        result = new Solution().detectCycle(listNode);
        System.out.println("could not print the linked list cause it has a cycle");
    }
}
