package will.zhang.UsingLinkedList.InsertionSortList147;
/**
  * @author will.zjw
  * @date 2019-11-22 16:27
  */
public class Solution {

    public ListNode insertionSortList(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead.next;

        while (cur != null) {
            ListNode next = cur.next;

            if (next != null && next.val < cur.val) {
                ListNode start = dummyHead;

                while (true) {
                    if (next.val <= start.next.val) {
                        cur.next = next.next;
                        next.next = start.next;
                        start.next = next;
                        break;
                    }
                    start = start.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 2, 1, 3};
        ListNode listNode = ListNode.create(arr1);

        Solution solution = new Solution();
        listNode = solution.insertionSortList(listNode);

        ListNode cur = listNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
