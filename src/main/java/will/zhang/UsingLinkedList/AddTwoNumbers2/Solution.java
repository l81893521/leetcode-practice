package will.zhang.UsingLinkedList.AddTwoNumbers2;
/**
  * @author will.zjw
  * @date 2019-11-14 17:06
  */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        ListNode sumNode = new ListNode(0);
        ListNode sum = sumNode;

        int step = 0;

        while (cur1 != null || cur2 != null || step > 0) {

            int a = 0, b = 0;
            if (cur1 != null) {
                a = cur1.val;
            }
            if ( cur2 != null) {
                b = cur2.val;
            }

            sum.next = new ListNode(((a + b + step) % 10));
            if (a + b + step >= 10) {
                step = 1;
            } else {
                step = 0;
            }
            sum = sum.next;

            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        return sumNode.next;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 4, 3};
        int[] arr2 = new int[]{5, 6, 4};
        ListNode node1 = ListNode.create(arr1);
        ListNode node2 = ListNode.create(arr2);

        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(node1, node2);

        ListNode cur = listNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
