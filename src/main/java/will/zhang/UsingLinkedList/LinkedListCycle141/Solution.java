package will.zhang.UsingLinkedList.LinkedListCycle141;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/16
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            if (fast.next == slow || fast.next.next == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = null;
        boolean result = new Solution().hasCycle(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});
        result = new Solution().hasCycle(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});
        ListNode cycle = listNode.get(4);
        cycle.next = listNode.get(2);
        result = new Solution().hasCycle(listNode);
        System.out.println(result);


    }
}
