package will.zhang.UsingLinkedList.MergeTwoSortedLists21;
/**
  * @author will.zjw
  * @date 2019-11-14 20:09
  */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode result = new ListNode(0);
        ListNode res = result;

        while (n1 != null || n2 != null) {
            if (n1 == null) {
                res.next = n2;
                n2 = n2.next;
            } else if (n2 == null) {
                res.next = n1;
                n1 = n1.next;
            }else if (n1.val < n2.val) {
                res.next = n1;
                n1 = n1.next;
            } else {
                res.next = n2;
                n2 = n2.next;
            }
            res = res.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 4};
        int[] arr2 = new int[]{4, 5, 6};
        ListNode node1 = ListNode.create(arr1);
        ListNode node2 = ListNode.create(arr2);

        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(node1, node2);

        ListNode cur = listNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
