package will.zhang.UsingLinkedList.AddTwoNumbersII445;

import java.util.Stack;

/**
  * @author will.zjw
  * @date 2019-11-14 18:16
  */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode n1 = l1;
        while (n1 != null) {
            stack1.push(n1.val);
            n1 = n1.next;
        }

        ListNode n2 = l2;
        while (n2 != null) {
            stack2.push(n2.val);
            n2 = n2.next;
        }

        ListNode head = null;
        int step = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || step > 0) {
            int value = 0;
            if (!stack1.isEmpty()) {
                value += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                value += stack2.pop();
            }
            value +=step;
            ListNode node = new ListNode(value % 10);
            step = value / 10;

            node.next = head;
            head = node;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{7, 2, 4, 3};
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
