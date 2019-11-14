package will.zhang.UsingLinkedList.RemoveDuplicatesFromListII82;
/**
  * @author will.zjw
  * @date 2019-11-14 19:39
  */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;

        while (cur.next != null) {
            boolean isDelSelf = false;
            while (cur.next.next != null && cur.next.val == cur.next.next.val) {
                cur.next.next = cur.next.next.next;
                isDelSelf = true;
            }
            if(isDelSelf) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 3, 4, 4, 5};
        ListNode node1 = ListNode.create(arr1);

        Solution solution = new Solution();
        ListNode listNode = solution.deleteDuplicates(node1);

        ListNode cur = listNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
