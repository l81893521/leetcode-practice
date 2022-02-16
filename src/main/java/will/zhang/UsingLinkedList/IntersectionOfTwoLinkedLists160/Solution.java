package will.zhang.UsingLinkedList.IntersectionOfTwoLinkedLists160;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/16
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // list node a length
        int aLength = 0;
        // list node b length
        int bLength = 0;
        for (ListNode listNode = headA; listNode.next != null; listNode = listNode.next) {
            aLength++;
        }
        for (ListNode listNode = headB; listNode.next != null; listNode = listNode.next) {
            bLength++;
        }

        //make list a and b in same distance from the end;
        if (aLength > bLength) {
            for (int i = 0; i < aLength - bLength; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < bLength - aLength; i++) {
                headB = headB.next;
            }
        }

        while (headA.next != null) {
            if (headA == headB) {
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        if (headA != headB) {
            return null;
        }
        return headA;
    }

    public static void main(String[] args) {
        ListNode a = null;
        ListNode b = null;
        ListNode result = new Solution().getIntersectionNode(a, b);
        System.out.println(result);

        a = ListNode.create(new int[]{1, 2, 3, 4, 5});
        b = ListNode.create(new int[]{1, 2});
        b.next = a.get(2);
        result = new Solution().getIntersectionNode(a, b);
        System.out.println(result);

        a = ListNode.create(new int[]{1, 2, 3, 4, 5});
        b = ListNode.create(new int[]{1, 2});
        result = new Solution().getIntersectionNode(a, b);
        System.out.println(result);


    }
}
