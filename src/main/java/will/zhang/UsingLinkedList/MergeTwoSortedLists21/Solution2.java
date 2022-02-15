package will.zhang.UsingLinkedList.MergeTwoSortedLists21;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/14
 */
public class Solution2 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode listNode = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                listNode.next = list1;
                list1 = list1.next;
            } else {
                listNode.next = list2;
                list2 = list2.next;
            }
            listNode = listNode.next;
        }

        if (list1 != null) {
            listNode.next = list1;
        }

        if (list2 != null) {
            listNode.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = ListNode.create(new int[]{2, 3, 4});
        System.out.println("l1:" + node1);
        ListNode node2 = ListNode.create(new int[]{4, 5, 6});
        System.out.println("l2:" + node2);

        ListNode listNode = new Solution2().mergeTwoLists(node1, node2);
        System.out.println(listNode);

        node1 = ListNode.create(new int[]{});
        System.out.println("l1:" + node1);
        node2 = ListNode.create(new int[]{4, 5, 6});
        System.out.println("l2:" + node2);

        listNode = new Solution2().mergeTwoLists(node1, node2);
        System.out.println(listNode);

        node1 = ListNode.create(new int[]{2, 3, 4});
        System.out.println("l1:" + node1);
        node2 = ListNode.create(new int[]{});
        System.out.println("l2:" + node2);

        listNode = new Solution2().mergeTwoLists(node1, node2);
        System.out.println(listNode);

        node1 = ListNode.create(new int[]{2, 3, 4});
        System.out.println("l1:" + node1);
        node2 = ListNode.create(new int[]{5});
        System.out.println("l2:" + node2);

        listNode = new Solution2().mergeTwoLists(node1, node2);
        System.out.println(listNode);
    }
}
