package will.zhang.UsingLinkedList.MergeKLists23;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/15
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);

        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode l = priorityQueue.poll();
            p.next = l;
            if (l.next != null) {
                priorityQueue.add(l.next);
            }

            p = p.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode[] lists = new ListNode[1];
        lists[0] = null;

        ListNode result = new Solution().mergeKLists(lists);
        System.out.println(result);

        lists = new ListNode[]{
                ListNode.create(new int[]{2, 3, 4}),
                ListNode.create(new int[]{}),
                ListNode.create(new int[]{3, 6, 9})
        };

        result = new Solution().mergeKLists(lists);
        System.out.println(result);

        lists = new ListNode[]{
                ListNode.create(new int[]{2, 3, 4}),
                ListNode.create(new int[]{1, 3, 7}),
                ListNode.create(new int[]{3, 6, 9})
        };

        result = new Solution().mergeKLists(lists);
        System.out.println(result);

        lists = new ListNode[]{
                ListNode.create(new int[]{2, 3, 4, 5, 9}),
                ListNode.create(new int[]{1, 3, 7}),
                ListNode.create(new int[]{3, 6, 9})
        };

        result = new Solution().mergeKLists(lists);
        System.out.println(result);

        lists = new ListNode[]{
                ListNode.create(new int[]{2, 3, 4}),
                ListNode.create(new int[]{1, 3, 7}),
                ListNode.create(new int[]{3, 6})
        };

        result = new Solution().mergeKLists(lists);
        System.out.println(result);

    }
}
