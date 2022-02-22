package will.zhang.UsingLinkedList.PalindromeLinkedList234;

import will.zhang.util.ListNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/22
 */
public class Solution2 {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //如果是奇数则slow多走一步
        if (fast != null) {
            slow = slow.next;
        }

        //从snow开始反转链表
        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});
        boolean result = new Solution2().isPalindrome(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 3, 2, 1});
        result = new Solution2().isPalindrome(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 3, 3, 2, 1});
        result = new Solution2().isPalindrome(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2});
        result = new Solution2().isPalindrome(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 1});
        result = new Solution2().isPalindrome(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2});
        result = new Solution2().isPalindrome(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 1, 1});
        result = new Solution2().isPalindrome(listNode);
        System.out.println(result);
    }
}
