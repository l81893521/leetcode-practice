package will.zhang.UsingLinkedList.PalindromeLinkedList234;

import will.zhang.util.ListNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/18
 */
public class Solution {

    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;

        return traverse(head);
    }

    public boolean traverse(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = traverse(head.next);
        res = res && head.val == left.val;
        left = left.next;
        return res;
    }



    public static void main(String[] args) {
        ListNode listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});
        boolean result = new Solution().isPalindrome(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 3, 2, 1});
        result = new Solution().isPalindrome(listNode);
        System.out.println(result);

        listNode = ListNode.create(new int[]{1, 2, 3, 3, 2, 1});
        result = new Solution().isPalindrome(listNode);
        System.out.println(result);
    }
}
