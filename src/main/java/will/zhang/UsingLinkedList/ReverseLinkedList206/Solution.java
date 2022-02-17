package will.zhang.UsingLinkedList.ReverseLinkedList206;

import will.zhang.util.ListNode;

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

        ListNode listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});

        ListNode reverNode = new Solution().reverseList(listNode);

        ListNode cur = reverNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}


