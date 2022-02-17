package will.zhang.UsingLinkedList.ReverseLinkedList206;

import will.zhang.util.ListNode;

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
        ListNode listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});

        ListNode reverseNode = new Solution2().reverseList(listNode);

        ListNode cur = reverseNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}


